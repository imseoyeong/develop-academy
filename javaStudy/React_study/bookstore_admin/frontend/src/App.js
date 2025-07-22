import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./page/MainLayout";
import Home from "./page/Home";
import OrderInfoLayout from "./page/OrderInfoLayout";
import ViewOrderInfo from "./page/ViewOrderInfo";
import ViewOrderInfo_Nodata from "./page/ViewOrderInfo_Nodata";
import ViewBookInfo from "./page/ViewBookInfo";
import ViewBookOrderInfo from "./page/ViewBookOrderInfo";

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<MainLayout/>}>
          <Route index element={<Home/>}/>
          <Route path={"/orderinfo"} element={<OrderInfoLayout/>}>
            <Route path={"/orderinfo/nodata"} element={<ViewOrderInfo_Nodata/>}/>
            <Route path={"/orderinfo/data"} element={<ViewOrderInfo/>}/>
            <Route path={"/orderinfo/bookinfo/:bookid"} element={<ViewBookInfo/>}/>
            <Route path={"/orderinfo/book-order-info"} element={<ViewBookOrderInfo/>}/>
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
