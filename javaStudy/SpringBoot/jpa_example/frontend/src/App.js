import logo from './logo.svg';
import './App.css';
import './style.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Home from "./Home";
import ConditionSelect from "./ConditionSelect";
import DetailCondition from "./DetailCondition";
import ViewUserInfo from "./ViewUserInfo";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<MainLayout/>}>
                    <Route index element={<Home/>}/>
                    <Route path="/search" element={<ConditionSelect/>}>
                        <Route path="/search/detail-condition" element={<DetailCondition/>}/>
                    </Route>
                    <Route path="/view-userinfo" element={<ViewUserInfo/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
