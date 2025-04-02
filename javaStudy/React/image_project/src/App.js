import { Route, Routes } from 'react-router-dom';

import MainLayout from './MainLayout';
import ImageList from './ImageList';
// import ImageContent from './ImageContent';
import "./style.css";

// import africaImage from "./img/africa.jpg";
// import africaImage1 from "./img/africa1.jpg";
// import africaImage2 from "./img/africa2.jpg";

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<MainLayout/>}>
                    <Route index element={<ImageList/>}></Route>
                    {/* <Route path='/list/:imgid' element={<ImageContent/>}></Route> */}
                </Route>
            </Routes>
        </>
    );
}

export default App;