import {useRef, useState} from "react";
import {useNavigate} from "react-router-dom";
import apiClient from "../api/axiosInstance";
import axios from "axios";
import {useSelector} from "react-redux";

export default function AdminJoin() {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const codenumRef = useRef();
    const [message, setMessage] = useState(null);
    const navigate = useNavigate();
    const csrfToken = useSelector(state => state.userInfo.token);

    const handleJoin = async (e) => {
        try {
            const response = await apiClient.post("/admin-join", {
                    username: usernameRef.current.value,
                    password: passwordRef.current.value,
                    codenum: codenumRef.current.value
                }, {
                    headers: {
                        "X-CSRF-TOKEN": csrfToken
                    },
                    withCredentials: true
                }
            );
            setMessage(response.data);
            // navigate("/admin-login");
        } catch (error) {
            if (error.response && error.response.status === 409) {
                setMessage(error.response.data);
            } else {
                console.log(error);
            }
        }
    }

    return (
        <>
            <form id={"join"}>
                <div>
                    <label htmlFor={"codenum"}>인증번호</label>
                    <input id={"codenum"} type={"text"} ref={codenumRef} name={"codenum"} placeholder={"인증번호 입력"}/>
                </div>
                <div>
                    <label htmlFor={"amdinid"}>관리자 아이디</label>
                    <input id={"adminid"} type={"text"} ref={usernameRef} name={"username"} placeholder={"아이디 입력"}/>
                </div>
                <div>
                    <label htmlFor={"amdinpw"}>관리자 비밀번호</label>
                    <input id={"adminpw"} type={"password"} ref={passwordRef} name={"password"} placeholder={"패스워드 입력"}/>
                </div>
                <div className={"btn-wrap"}>
                    <button type={"button"} name={"amdinJoin"} onClick={handleJoin}>관리자 추가</button>
                </div>
            </form>
            {message}
        </>
    );
}