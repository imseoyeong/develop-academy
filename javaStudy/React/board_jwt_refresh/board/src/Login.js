import axios from "axios";

export default function Login() {
    const handleSubmit = async (e) => {
        e.preventDefault();

        const loginList = {username: username, password: password};
        new URLSearchParams(loginList);

        try {
            await axios.post("http://localhost:8080/login", {

            })
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <form className={"inner"} onSubmit={handleSubmit}>
            <input name={"username"} type={"text"} placeholder={"아이디"}/>
            <input name={"password"} type={"password"} placeholder={"비밀번호"}/>
            <button type={"submit"}>로그인</button>
        </form>
    );
}