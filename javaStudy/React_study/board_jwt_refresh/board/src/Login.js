import axios from "axios";
import {useDispatch} from "react-redux";
import {useNavigate} from "react-router-dom";
import {setToken, userLogin} from "./userListSlice";
import apiClient from "./api/axiosInstance";

export default function Login() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const data = {username: e.target.username.value, password: e.target.password.value};

        try {
            const response = await apiClient.post("/login", new URLSearchParams(data));
            dispatch(userLogin(response.data));
            navigate("/");
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <form className={"inner"} onSubmit={handleSubmit}>
            <input name={"username"} type={"text"} placeholder={"아이디"}/>
            <input name={"password"} type={"password"} placeholder={"비밀번호"}/>
            <button className={"btn"} type={"submit"}>로그인</button>
        </form>
    );
}