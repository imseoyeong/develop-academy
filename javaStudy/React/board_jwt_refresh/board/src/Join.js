import axios from "axios";
import {useDispatch} from "react-redux";
import {addUsers} from "./userListSlice";
import {useNavigate} from "react-router-dom";

export default function Join() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const userFullName = e.target.userFullName.value;
        const username = e.target.username.value;
        const password = e.target.password.value;

        try {
            const response = await axios.post("http://localhost:8080/join", {
                userFullName,
                username,
                password,
            });

            dispatch(addUsers(response.data));
            navigate("/login");
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <form className={"inner"} onSubmit={handleSubmit}>
            <input name={"userFullName"} type={"text"} placeholder={"이름"}/>
            <input name={"username"} type={"text"} placeholder={"아이디"}/>
            <input name={"password"} type={"password"} placeholder={"비밀번호"}/>
            <button className={"btn"} type={"submit"}>회원가입</button>
        </form>
    );
}