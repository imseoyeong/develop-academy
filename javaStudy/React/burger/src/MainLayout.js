import {Link} from "react-router-dom";
import {useSelector} from "react-redux";

export default function MainLayout() {
    const menuList = useSelector((state) => state.menuList.menu);

    return (
        <header>
            <h1><Link to="/">서영날드~</Link></h1>
            <ul>
                {menuList.map((m) => (
                <li>{m.title}</li>
                ))}
            </ul>
        </header>
    );
}