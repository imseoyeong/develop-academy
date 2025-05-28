import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Login from "./Login";
import AdminComponent from "./AdminComponent";
import {useEffect} from "react";
import axios from "axios";
import apiClient from "./api/apiinstance";
import {useDispatch} from "react-redux";
import {setToken} from "./store";

function App() {
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await apiClient.get("/csrf-token", {
                    withCredentials: true
                });
                dispatch(setToken(response.data['csrf-token']));
                console.log(response.data['csrf-token']);
            } catch (error) {

            }
        }
        fetchData();
    }, []);

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
