import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import store, {setToken} from "../store";

const apiClient = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        "Content-Type": "application/json",
    },
    withCredentials: true,
    timeout: 3000,
});

apiClient.interceptors.request.use((config) => {
    // 1. 요청 데이터가 URLSearchParams 타입인지 확인
    if (config.data && config.data instanceof URLSearchParams) {
        config.headers["Content-Type"] = "application/x-www-form-urlencoded";
    }

    const token = store.getState().userInfo.token;
    if (token) {
        config.headers["Authorization"] = token;
    }

    // 2. 요청 메서드가 GET이 아닌 경우 CSRF 토큰 추가
    if (config.method && config.method.toLowerCase() !== "get") {
        const csrfToken = store.getState().userInfo.csrfToken; // Redux 상태에서 csrfToken 가져오기
        config.headers["X-CSRF-TOKEN"] = csrfToken;
    }

    return config; // 수정된 config 반환
}, (error) => {
    // 요청을 가로채는 중에 에러 발생 시 처리
    return Promise.reject(error);
});

apiClient.interceptors.response.use((response) => response,
    async (error) => {
        const originalRequest = error.config;
        if (error.response && error.response.status === 456 && !originalRequest._retry) {
            originalRequest._retry = true;

            try {
                const response = await axios.post("http://localhost:8080/reissue", null, {
                    withCredentials: true,
                });

                const newAccess = response.headers["authorization"];
                store.dispatch(setToken(newAccess));

                originalRequest.headers["Authorization"] = newAccess;

                console.log("만료된 요청 재시도");
                return apiClient(originalRequest);
            } catch (error) {
                console.error("리프레시 토큰으로 재발급 실패:", error);
                return Promise.reject(error);
            }
        }
        return Promise.reject(error);
    });

export default apiClient;