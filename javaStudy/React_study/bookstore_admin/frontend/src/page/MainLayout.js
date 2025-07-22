import {Link, Outlet} from "react-router-dom";

export default function MainLayout() {
    return (
        <>
            <header>
                <h1>Book Store Admin</h1>
                <nav>
                    <Link to={"/"}>홈</Link>
                    <Link to={"/orderinfo"}>주문정보확인</Link>
                </nav>
            </header>

            <Outlet/>
        </>
    );
}