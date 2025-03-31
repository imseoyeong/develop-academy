import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ParentComponent from './ParentComponent';
import ChildComponent from './ChildComponent';
import GrandchildComponent from './GrandchildComponent';

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/parent' element={<ParentComponent/>}>
                <Route path='/parent/child' element={<ChildComponent/>}>
                    <Route path='/parent/child/grandchild' element={<GrandchildComponent/>}></Route>
                </Route>
            </Route>
        </Routes>
    </BrowserRouter>
  );
}

export default App;
