import {useParams} from "react-router-dom";
import {useSelector} from "react-redux";

export default function Detail() {
    const {menuId} = useParams();
    const menu = useSelector(state=>state.menuList.menu.find((m)=>m.id === Number(menuId)));

    const menuList = [];
    for (let i=0; i<2; i++) {
        const srcSpilt =
    }

    return (
        <>
            <ul>
                <li><img/></li>
            </ul>
        </>
    );
}