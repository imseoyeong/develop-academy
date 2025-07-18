import {Link, Outlet} from "react-router-dom";

export default function AddUserInfo() {
    return (
        <>
            <nav>
                <Link to={"/add-userinfo/joininfo"}>가입 정보 추가</Link>
                <Link to={"/add-userinfo/buyinfo"}>구매 기록 추가</Link>
            </nav>

            <Outlet/>
        </>
    );
}