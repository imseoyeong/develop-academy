import axios from "axios";
import store from "../store";

const apiClient = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        "Content-Type": "application/json",
    },
    timeout: 3000,
    withCredentials: true
});

apiClient.interceptors.request.use((config) => {
    // 1. 요청 데이터가 URLSearchParams 타입인지 확인
    if (config.data && config.data instanceof URLSearchParams) {
        config.headers["Content-Type"] = "application/x-www-form-urlencoded";
    }

    // 2. 요청 메서드가 get이 아닌 경우 csrf 토큰 추가
    if (config.method && config.method.toLowerCase() !== "get") {
        const csrfToken = store.getState().userInfo.token;
        config.headers["X-CSRF-TOKEN"] = csrfToken;
    }
    return config; // 수정된 config 반환
}, (error) => {
    // 요청을 가로채는 중에 에러 발생 시 처리
    return Promise.reject(error);
});

export default apiClient;