import logo from './logo.svg';
import './App.css';
import './style.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Home from "./Home";
import ConditionSelect from "./ConditionSelect";
import DetailCondition from "./DetailCondition";
import ViewUserInfo from "./ViewUserInfo";
import ViewBuyHistory from './ViewBuyHistory';
import AddUserInfo from './AddUserInfo';
import AddJoinInfo from './AddJoinInfo';
import AddBuyHistory from './AddBuyHistory';

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
                    <Route path="/view-buyhistory/:userid" element={<ViewBuyHistory/>}/>
					<Route path="/add-userinfo" element={<AddUserInfo/>}>
						<Route index element={<AddJoinInfo/>}/>
						<Route path="/add-userinfo/add-buyhistory" element={<AddBuyHistory/>}/>
					</Route>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
