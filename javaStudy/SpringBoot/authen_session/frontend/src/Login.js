import {useRef, useState} from "react";
import apiClient from "./api/apiinstance";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {setToken} from "./store";

export default function Login() {
    const usernameRef = useRef();
    const passwordRef = useRef();
    const [message, setMessage] = useState(null);
    const navigate = useNavigate();
    const csrfToken = useSelector(state => state.token.token);
    const dispatch = useDispatch();

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
            // setMessage(response.data.role[0].authority);
            // setMessage(response.data.username);
            dispatch(setToken(response.data['csrf-token']));
            console.log(response.data['csrf-token']);
            navigate("/admin");
        } catch (error) {
            if (error.response && error.response.status === 401) {
                setMessage(error.response.data.result);
            } else {
                console.log(error);
            }
        }
    }

    const handleJoin = async (e) => {
        try {
            const response = await apiClient.post("/join", {
                username: usernameRef.current.value,
                password: passwordRef.current.value
            }, {
                headers: {
                    "X-CSRF-TOKEN": csrfToken
                },
                withCredentials: true
            });
            setMessage(response.data);
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
            <form id={"login"}>
                <div className={"input-box"}>
                    <input type={"text"} ref={usernameRef} name={"username"} placeholder={"아이디 입력"}/>
                    <input type={"password"} ref={passwordRef} name={"password"} placeholder={"패스워드 입력"}/>
                </div>
                <div className={"btn-wrap"}>
                    <button type={"button"} name={"login"} onClick={handleLogin}>Login</button>
                    <button type={"button"} name={"join"} onClick={handleJoin}>Join</button>
                </div>
            </form>
            {message}
        </>
    );
}