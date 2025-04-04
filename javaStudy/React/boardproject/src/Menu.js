import { Link } from "react-router-dom";

export default function Menu(props) {
    const menuArr = [];
    for (let m of props.menuList) {
        const item =
            <li key={m.id}>
                <Link to={m.path}>{m.title}</Link>
            </li>;
            menuArr.push(item);
    }

    return (
        <ul className='menu-list'>
            {menuArr}
        </ul>
    );
}