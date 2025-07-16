import {Link, Outlet} from "react-router-dom";

export default function MainLayout() {
    return (
        <>
            <header>
                <h1>고객 관리</h1>
                <nav>
                    <Link to={"/"}>홈</Link>
                    <Link to={"/search"}>검색</Link>
                    <Link to={"/add-userinfo"}>고객정보추가</Link>
                </nav>
            </header>

            <Outlet/>
        </>
    );
}