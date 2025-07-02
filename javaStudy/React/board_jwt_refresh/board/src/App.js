import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Main from "./Main";
import BoardList from "./BoardList";
import BoardWrite from "./BoardWrite";
import BoardView from "./BoardView";
import Login from "./Login";
import Join from "./Join";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<MainLayout/>}>
                    <Route index element={<Main/>}/>
                    <Route path={"/login"} element={<Login/>}/>
                    <Route path={"/join"} element={<Join/>}/>
                    <Route path={"/list"} element={<BoardList/>}/>
                    <Route path={"/list/:itemId"} element={<BoardView/>}/>
                    <Route path={"/write"} element={<BoardWrite/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
