import {Link, Outlet} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";
import {useDispatch} from "react-redux";
import {setBoardItem} from "./boardListSlice";

export default function MainLayout() {
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("http://localhost:8080/postlist");
                dispatch(setBoardItem(response.data));
            } catch (e) {
                console.log(e);
            }
        };

        fetchData();
    }, []);

    return (
        <>
            <header className={"inner"}>
                <h1 className={"logo"}><Link to={"/"}>게시판</Link></h1>
                <nav>
                    <Link to={"/list"}>목록</Link>
                    <Link to={"/write"}>글쓰기</Link>
                    <Link to={"/login"}>로그인</Link>
                    <Link to={"/join"}>회원가입</Link>
                </nav>
            </header>
            <Outlet/>
        </>
    );
}