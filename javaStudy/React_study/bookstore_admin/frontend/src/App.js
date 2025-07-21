import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Home from "./Home";
import OrderInfoLayout from "./OrderInfoLayout";

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<MainLayout/>}>
          <Route index element={<Home/>}/>
          <Route path={"/orderinfo"} element={<OrderInfoLayout/>}>

          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
