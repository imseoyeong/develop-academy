import {Link} from "react-router-dom";

export default function Login() {
    return (
        <section id={"login"}>
            <form>
                <ul>
                    <li>
                        <label>아이디</label>
                        <input type={"text"} placeholder={"아이디를 입력해주세요"}/>
                    </li>
                    <li>
                        <label>비밀번호</label>
                        <input type={"password"} placeholder={"비밀번호를 입력해주세요"}/>
                    </li>
                </ul>

                <div className={"btn-wrap"}>
                    <button type={"submit"}>로그인</button>
                </div>

                <div>
                    <Link to={""}>카카오로 로그인</Link>
                    <Link to={""}>네이버로 로그인</Link>
                    <Link to={""}>구글로 로그인</Link>
                </div>

                <Link to={""}>지금 바로 회원가입</Link>
            </form>
        </section>
    );
}