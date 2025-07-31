import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import StartScreen from "./page/StartScreen";
import Home from "./page/Home";
import Login from "./page/Login";
import Signup from "./page/Signup";
import Connect from "./page/Connect";
import MainLayout from "./page/MainLayout";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path={"/"} element={<StartScreen/>}/>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"/login"} element={<Login/>}/>
                    <Route path={"/signup"} element={<Signup/>}/>
                    <Route path={"/connect"} element={<Connect/>}/>

                    <Route path={"/"} element={<MainLayout/>}>

                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
