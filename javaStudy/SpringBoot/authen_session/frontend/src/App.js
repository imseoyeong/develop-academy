import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Login from "./Login";
import AdminComponent from "./AdminComponent";

function App() {
    return (
        <>
            <section className={"inner"}>
                <BrowserRouter>
                    <Routes>
                        <Route path={"/"} element={<MainLayout/>}>
                            <Route index element={<Login/>}/>
                            <Route path={"/admin"} element={<AdminComponent/>}/>
                        </Route>
                    </Routes>
                </BrowserRouter>
            </section>
        </>
    );
}

export default App;
