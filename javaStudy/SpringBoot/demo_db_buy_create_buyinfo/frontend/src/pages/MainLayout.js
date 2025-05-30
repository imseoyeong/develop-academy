import {Link, Outlet} from "react-router-dom";
import {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {logout} from "../store";
import axios from "axios";

export default function MainLayout() {
    const isLogin = useSelector(state => state.userInfo.isLogin);
    const role = useSelector(state => state.userInfo.role);

    return (
        <>
            <div className={"inner"}>
                <h1>👀USER ADMIN</h1>

                {!isLogin && (
                    <ul className={"menu-list"}>
                        <li><Link to={"/user-login"}>유저 로그인</Link></li>
                        <li><Link to={"/admin-login"}>관리자 로그인</Link></li>
                        <li><Link to={"/admin-join"}>관리자 추가</Link></li>
                    </ul>
                )}

                {isLogin && (
                    <ul className={"menu-list"}>
                        <li><Link to={"/"}>홈</Link></li>
                        <li><Link to={"/search"}>검색</Link></li>
                        {role.some(r => r.authority === 'ROLE_ADMIN') && (
                        <li><Link to={"/create-userinfo"}>고객정보추가</Link></li>
                        )}
                        <li><Link to={"/logout"}>로그아웃</Link></li>
                    </ul>
                )}

                <Outlet/>
            </div>
        </>
    );
}