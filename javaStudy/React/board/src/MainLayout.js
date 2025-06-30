import {Link, Outlet} from "react-router-dom";

export default function MainLayout() {
    return (
        <>
            <header className={"inner"}>
                <h1 className={"logo"}><Link to={"/"}>게시판</Link></h1>
                <nav>
                    <Link to={"/list"}>목록</Link>
                    <Link to={"/write"}>글쓰기</Link>
                </nav>
            </header>
            <Outlet/>
        </>
    );
}