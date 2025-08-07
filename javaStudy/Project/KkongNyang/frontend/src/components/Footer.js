import {NavLink} from "react-router-dom";

export default function Footer() {
    return (
        <footer>
            <nav>
                <NavLink to={"/home"}>홈</NavLink>
                <NavLink to={"/bucket"}>버킷</NavLink>
                <NavLink to={"/album"}>앨범</NavLink>
                <NavLink to={"/mypage"}>마이</NavLink>
            </nav>
        </footer>
    );
}