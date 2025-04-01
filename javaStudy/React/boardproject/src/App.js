import { Route, Routes } from 'react-router-dom';
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
                <Route path='/write' element={<Write/>}></Route>
                <Route path='/post/:postid' element={<Read/>}></Route>
            </Route>
        </Routes>
        </>
    );
}

export default App;