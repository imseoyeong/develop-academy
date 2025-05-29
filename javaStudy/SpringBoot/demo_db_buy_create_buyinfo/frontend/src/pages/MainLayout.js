import {Link, Outlet} from "react-router-dom";
import {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {logout} from "../store";
import axios from "axios";

export default function MainLayout(){
    const [message, setMessage] = useState(null);
    const isLogin = useSelector(state => state.auth.isLogin);
    const dispatch = useDispatch();

    const handleLogout = async (e) => {
        try {
            const response = await axios.post("http://localhost:8080/logout", {},
                {
                    withCredentials: true,
                }
            );
            dispatch(logout());
            setMessage(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <>
            <h1>&lt;고객 관리&gt;</h1>

            {!isLogin && (
            <div>
                <Link to={"/admin-login"}>관리자 로그인</Link>|
                <Link to={"/admin-join"}>관리자 추가</Link>
            </div>
            )}

            {isLogin && (
            <div>
                <Link to={"/"}>홈</Link>|
                <Link to={"/search"}>검색</Link>|
                <Link to={"/create-userinfo"}>고객정보추가</Link>|
                <Link onClick={handleLogout}>로그아웃</Link>
            </div>
            )}

            <Outlet/>
        </>
    );
}