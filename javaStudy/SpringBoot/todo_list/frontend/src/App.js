import { Route, Routes } from 'react-router-dom';
import MainLayout from './MainLayout';
import TodoList from './TodoList';

function App() {
  return (
    <>
    <Routes>
        <Route path="/" element={<MainLayout/>}>
            <Route index element={<TodoList/>}></Route>
        </Route>
    </Routes>
    </>
  );
}

export default App;
