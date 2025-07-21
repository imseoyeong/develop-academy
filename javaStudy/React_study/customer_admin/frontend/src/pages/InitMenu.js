import {Link} from "react-router-dom";

export default function InitMenu() {
    return (
        <>
            <nav>
                <Link to={"/"}>홈</Link>
                <Link to={"/user-login"}>일반 로그인</Link>
                <Link to={"/admin-login"}>관리자 로그인</Link>
                <Link to={"/add-admin"}>관리자 추가</Link>
            </nav>
        </>
    );
}