import {Link, useNavigate} from "react-router-dom";
import apiClient from "../api/axiosInstance";
import {useDispatch} from "react-redux";
import {userLogin} from "../store/userSlice";
import {setToken} from "../store/tokenSlice";

// 로그인 시 커플코드 입력, 입력 후 커플프로필 작성 페이지로.

export default function Login() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        const data = {
            username: e.target.username.value,
            password: e.target.password.value,
        }

        try {
            const response = await apiClient.post("/login", new URLSearchParams(data), {
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
            });

            dispatch(setToken(response.headers["authorization"]));
            dispatch(userLogin());


            navigate("/home");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <section id={"login"}>
            <form onSubmit={handleLogin}>
                <ul>
                    <li>
                        <label>아이디</label>
                        <input type={"text"} placeholder={"아이디를 입력해주세요"} name={"username"} required/>
                    </li>
                    <li>
                        <label>비밀번호</label>
                        <input type={"password"} placeholder={"비밀번호를 입력해주세요"} name={"password"} required/>
                    </li>
                </ul>

                <div className={"btn-wrap"}>
                    <button type={"submit"}>로그인</button>
                </div>

                <div>
                    <Link to={"#"}>카카오로 로그인</Link>
                    <Link to={"#"}>네이버로 로그인</Link>
                    <Link to={"#"}>구글로 로그인</Link>
                </div>

                <Link to={"/signup"}>지금 바로 회원가입</Link>
            </form>
        </section>
    );
}