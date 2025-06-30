import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import MainLayout from "./MainLayout";
import Detail from "./Detail";

function App() {
  return (
      <>
      <Routes>
        <Route path={"/"} element={<MainLayout/>}>
            <Route path={"/menuList/:menuId"} element={<Detail/>}/>
        </Route>
      </Routes>
      </>
  );
}

export default App;
