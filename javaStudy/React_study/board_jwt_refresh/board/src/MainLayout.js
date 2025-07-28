import {Link, Outlet, useNavigate} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {setBoardItem} from "./boardListSlice";
import {userLogout} from "./userListSlice";
import apiClient from "./api/axiosInstance";

export default function MainLayout() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const isLogin = useSelector((state) => state.userList.userLoginFlag);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await apiClient.get("/postlist");
                dispatch(setBoardItem(response.data));
            } catch (e) {
                console.log(e);
            }
        };

        fetchData();
    }, []);

    const handleLogout = () => {
        dispatch(userLogout());
        navigate("/");
    }

    return (
        <>
            <header className={"inner"}>
                <h1 className={"logo"}><Link to={"/"}>게시판</Link></h1>
                {isLogin ? (
                    <nav>
                        <Link to={"/list"}>목록</Link>
                        <Link to={"/write"}>글쓰기</Link>
                        <button onClick={handleLogout}>로그아웃</button>
                    </nav>
                ) : (
                    <nav>
                        <Link to={"/list"}>목록</Link>
                        <Link to={"/login"}>로그인</Link>
                        <Link to={"/join"}>회원가입</Link>
                    </nav>
                )}
            </header>
            <Outlet/>
        </>
    );
}