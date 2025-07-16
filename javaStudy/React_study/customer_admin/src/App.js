import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./pages/MainLayout";
import Home from "./pages/Home";
import Search from "./pages/Search";
import SearchInput from "./pages/SearchInput";
import ViewUserInfo from "./pages/ViewUserInfo";
import ViewBuyInfo from "./pages/ViewBuyInfo";

function App() {
  return (
      <>
          <BrowserRouter>
              <Routes>
                  <Route path={"/"} element={<MainLayout/>}>
                      <Route index element={<Home/>}/>
                      <Route path={"/search"} element={<Search/>}>
                          <Route path={"/search/search-input"} element={<SearchInput/>}/>
                      </Route>
                      <Route path={"/view-userinfo"} element={<ViewUserInfo/>}/>
                      <Route path={"/view-buyinfo/:userId"} element={<ViewBuyInfo/>}/>
                  </Route>
              </Routes>
          </BrowserRouter>
      </>
  );
}

export default App;
