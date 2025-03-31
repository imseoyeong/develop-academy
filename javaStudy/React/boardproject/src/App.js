import { useState } from 'react';
import { Link, Outlet, Route, Routes, useNavigate, useParams } from 'react-router-dom';
import "./Style.css";
import MainLayout from './MainLayout';
import Write from './Write';
import List from './List';
import Read from './Read';


function App() {
    return (
        <>
        <Routes>
            <Route path='/' element={<MainLayout/>}>
                <Route index element={<List/>}></Route>
                <Route path='/list/:postid' element={<Read/>}></Route>
                <Route path='/write' element={<Write/>}></Route>
            </Route>
        </Routes>
        </>
    );
}

export default App;