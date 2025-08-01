import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import StartScreen from "./pages/StartScreen";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import ConnectCouple from "./pages/ConnectCouple";
import MainLayout from "./components/MainLayout";
import AuthLayout from "./components/AuthLayout";
import CoupleProfile from "./pages/CoupleProfile";
import MyPageLayout from "./components/MyPageLayout";
import MyPage from "./pages/MyPage";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route element={<AuthLayout/>}>
                        <Route path={"/"} element={<StartScreen/>}/>
                        <Route path={"/login"} element={<Login/>}/>
                        <Route path={"/signup"} element={<Signup/>}/>
                        <Route path={"/connect"} element={<ConnectCouple/>}/>
                        <Route path={"/couple-profile"} element={<CoupleProfile/>}/>
                    </Route>

                    <Route element={<MainLayout/>}>
                        <Route path={"/home"} element={<Home/>}/>
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
