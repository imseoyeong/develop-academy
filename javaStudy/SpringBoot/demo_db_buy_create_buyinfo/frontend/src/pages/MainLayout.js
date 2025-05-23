import {Link, Outlet} from "react-router-dom";

export default function MainLayout(){
    return (
        <>
            <h1>&lt;고객 관리&gt;</h1>
            <Link to={"/"}>홈</Link>|<Link to={"/search"}>검색</Link>|
            <Link to={"/create-userinfo"}>고객정보추가</Link>
            <Outlet/>
        </>
    );
}