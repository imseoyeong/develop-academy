import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./pages/MainLayout";
import Home from "./pages/Home";
import Search from "./pages/Search";
import SearchInput from "./pages/SearchInput";
import ViewUserInfo from "./pages/ViewUserInfo";
import ViewBuyInfo from "./pages/ViewBuyInfo";
import AddUserInfo from "./pages/AddUserInfo";
import JoinInfo from "./pages/JoinInfo";
import BuyInfo from "./pages/BuyInfo";
import JoinInfoResult from "./pages/JoinInfoResult";
import BuyInfoResult from "./pages/BuyInfoResult";
import UserLogin from "./pages/UserLogin";
import AdminLogin from "./pages/AdminLogin";
import AddAdmin from "./pages/AddAdmin";
import Logout from "./pages/Logout";

function App() {
  return (
      <>
          <BrowserRouter>
              <Routes>
                  <Route path={"/"} element={<MainLayout/>}>
                      <Route index element={<Home/>}/>

                      <Route path={"/logout"} element={<Logout/>}/>
                      <Route path={"/user-login"} element={<UserLogin/>}/>
                      <Route path={"/admin-login"} element={<AdminLogin/>}/>
                      <Route path={"/add-admin"} element={<AddAdmin/>}/>

                      <Route path={"/search"} element={<Search/>}>
                          <Route path={"/search/search-input"} element={<SearchInput/>}/>
                      </Route>

                      <Route path={"/view-userinfo"} element={<ViewUserInfo/>}/>
                      <Route path={"/view-buyinfo/:userId"} element={<ViewBuyInfo/>}/>

                      <Route path={"/add-userinfo"} element={<AddUserInfo/>}>
                          <Route path={"/add-userinfo/joininfo"} element={<JoinInfo/>}/>
                          <Route path={"/add-userinfo/joininfo-result"} element={<JoinInfoResult/>}/>
                          <Route path={"/add-userinfo/buyinfo"} element={<BuyInfo/>}/>
                          <Route path={"/add-userinfo/buyinfo-result"} element={<BuyInfoResult/>}/>
                      </Route>
                  </Route>
              </Routes>
          </BrowserRouter>
      </>
  );
}

export default App;
