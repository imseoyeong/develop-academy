import {useRef, useState} from "react";
import {useNavigate} from "react-router-dom";
import apiClient from "../api/axiosInstance";
import axios from "axios";
import {useDispatch} from "react-redux";
import {login} from "../store";

export default function AdminLogin() {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const [message, setMessage] = useState(null);
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleLogin = async (e) => {
        try {
            const response = await axios.post("http://localhost:8080/admin-login",
                new URLSearchParams({
                    username: usernameRef.current.value,
                    password: passwordRef.current.value
                }), {
                    withCredentials: true
                }
            );
            dispatch(login(usernameRef.current.value));
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
                    <label htmlFor={"amdinid"}>관리자 아이디</label>
                    <input id={"adminid"} type={"text"} ref={usernameRef} name={"username"} placeholder={"아이디 입력"}/>
                </div>
                <div>
                    <label htmlFor={"amdinpw"}>관리자 비밀번호</label>
                    <input id={"adminpw"} type={"password"} ref={passwordRef} name={"password"} placeholder={"패스워드 입력"}/>
                </div>
                <div className={"btn-wrap"}>
                    <button type={"button"} name={"amdinlogin"} onClick={handleLogin}>관리자 로그인</button>
                </div>
            </form>
            {message}
        </>
    );
}