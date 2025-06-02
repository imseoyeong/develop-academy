import {useRef, useState} from "react";
import {useNavigate} from "react-router-dom";
import apiClient from "../api/axiosInstance";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {login, setRole, setToken} from "../store";

export default function AdminLogin() {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const [message, setMessage] = useState(null);
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const csrfToken = useSelector(state => state.userInfo.token);

    const handleLogin = async (e) => {
        try {
            const response = await axios.post("http://localhost:8080/login", // apiClient로 보내면 오류나서 axios로
                new URLSearchParams({ // x-www-form-urlencoded 형식
                    username: usernameRef.current.value,
                    password: passwordRef.current.value
                }), {
                    headers: {
                        "X-CSRF-TOKEN": csrfToken
                    },
                    withCredentials: true
                }
            );

            if (!response.data.role.includes('ROLE_ADMIN')) {
                alert("관리자 계정이 아닙니다.");
                return;
            }

            dispatch(setToken(response.data['csrf-token']));
            dispatch(login(usernameRef.current.value));
            dispatch(setRole(response.data.role));
            console.log(response.data['csrf-token']);
            navigate("/");
        } catch (error) {
            if (error.response && error.response.status === 401) {
                setMessage(error.response.data.result);
            } else {
                console.log(error);
            }
        }
    }

    return (
        <>
            <form id={"login"}>
                <div>
                    <label htmlFor={"adminid"}>관리자 아이디</label>
                    <input id={"adminid"} type={"text"} ref={usernameRef} name={"username"} placeholder={"아이디 입력"}/>
                </div>
                <div>
                    <label htmlFor={"adminpw"}>관리자 비밀번호</label>
                    <input id={"adminpw"} type={"password"} ref={passwordRef} name={"password"} placeholder={"패스워드 입력"}/>
                </div>
                <div className={"btn-wrap"}>
                    <button type={"button"} name={"adminlogin"} onClick={handleLogin}>관리자 로그인</button>
                </div>
            </form>
            {message}
        </>
    );
}