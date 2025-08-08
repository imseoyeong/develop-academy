import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import StartScreen from "./pages/StartScreen";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import ConnectCouple from "./pages/ConnectCouple";
import MainLayout from "./pages/MainLayout";
import AuthLayout from "./pages/AuthLayout";
import CoupleProfile from "./pages/CoupleProfile";
import MyPageLayout from "./pages/MyPageLayout";
import MyPage from "./pages/MyPage";
import CheckCoupleStatus from "./pages/CheckCoupleStatus";
import BucketList from "./pages/BucketList";
import Album from "./pages/Album";
import Logout from "./pages/Logout";
import AddBucket from "./pages/AddBucket";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route element={<AuthLayout/>}>
                        <Route path={"/"} element={<StartScreen/>}/>
                        <Route path={"/login"} element={<Login/>}/>
                        <Route path={"/couple-check"} element={<CheckCoupleStatus/>}/>
                        <Route path={"/signup"} element={<Signup/>}/>
                        <Route path={"/connect"} element={<ConnectCouple/>}/>
                        <Route path={"/couple-profile"} element={<CoupleProfile/>}/>
                        <Route path={"/logout"} element={<Logout/>}/>
                    </Route>

                    <Route element={<MainLayout/>}>
                        <Route path={"/home"} element={<Home/>}/>
                        <Route path={"/bucket"} element={<BucketList/>}/>
                        <Route path={"/album"} element={<Album/>}/>
                        <Route path={"/mypage"} element={<MyPageLayout/>}>
                            <Route index element={<MyPage/>}/>
                        </Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
