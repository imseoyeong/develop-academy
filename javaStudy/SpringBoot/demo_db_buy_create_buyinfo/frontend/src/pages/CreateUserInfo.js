import {NavLink, Link, Outlet} from "react-router-dom";

export default function CreateUserInfo(){
    return (
        <>
            <ul className='menu-list small'>
                <li><Link to={"/create-userinfo/join"}>가입 정보 추가</Link></li>
                <li><Link to={"/create-userinfo/add-buyinfo"}>구매 기록 추가</Link></li>
            </ul>
            <Outlet></Outlet>
        </>
    );
}