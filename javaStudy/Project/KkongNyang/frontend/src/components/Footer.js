import {NavLink} from "react-router-dom";

export default function Footer() {
    return (
        <footer>
            <nav>
                <NavLink to={"#"}>홈</NavLink>
                <NavLink to={"#"}>버킷</NavLink>
                <NavLink to={"#"}>앨범</NavLink>
                <NavLink to={"#"}>마이</NavLink>
            </nav>
        </footer>
    );
}