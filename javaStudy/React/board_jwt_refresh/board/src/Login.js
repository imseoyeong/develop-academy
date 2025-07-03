import axios from "axios";
import {useDispatch} from "react-redux";
import {useNavigate} from "react-router-dom";
import {setToken, userLogin} from "./userListSlice";

export default function Login() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const data = {username: e.target.username.value, password: e.target.password.value};

        try {
            const response = await axios.post("http://localhost:8080/login", new URLSearchParams(data), {
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                withCredentials: true,
            });
            dispatch(setToken(response.headers['authorization']));
            console.log(response.headers["authorization"]);
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