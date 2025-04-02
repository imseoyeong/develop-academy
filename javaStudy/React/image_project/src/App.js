import { Route, Routes } from 'react-router-dom';

import MainLayout from './MainLayout';
import Africa from './Africa';
import Brazil from './Brazil';
import Canada from './Canada';
import Cuba from './Cuba';
// import ImageList from './components/ImageList';
import ImageContent from './ImageContent';
import "./style.css";


function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<MainLayout/>}>
                    {/* <Route path='/africa' element={<Africa/>}></Route>
                    <Route path='/brazil' element={<Brazil/>}></Route>
                    <Route path='/canada' element={<Canada/>}></Route>
                    <Route path='/cuba' element={<Cuba/>}></Route> */}
                    <Route path='/imgList/:imgid' element={<ImageContent/>}></Route>
                </Route>
            </Routes>
        </>
    );
}

export default App;