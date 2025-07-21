import {Outlet} from "react-router-dom";
import {useSelector} from "react-redux";
import InitMenu from "./InitMenu";
import MainMenu from "./MainMenu";

export default function MainLayout() {
    const adminLoginFlag = useSelector(state => state.userInfo.adminLoginFlag);
    const userLoginFlag = useSelector(state => state.userInfo.userLoginFlag);

    return (
        <>
            <header>
                <h1>고객 관리</h1>
                {!(adminLoginFlag || userLoginFlag) ? <InitMenu/> : <MainMenu/>}
            </header>

            <Outlet/>
        </>
    );
}