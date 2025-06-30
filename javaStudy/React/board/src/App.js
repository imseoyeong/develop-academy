import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Main from "./Main";
import BoardList from "./BoardList";
import BoardWrite from "./BoardWrite";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<MainLayout/>}>
                    <Route index element={<Main/>}/>
                    <Route path={"/list"} element={<BoardList/>}/>
                    <Route path={"/write"} element={<BoardWrite/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
