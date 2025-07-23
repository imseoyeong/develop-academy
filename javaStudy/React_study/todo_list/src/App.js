import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import TodoLayout from "./TodoLayout";
import TodoList from "./TodoList";
import AddTodo from "./AddTodo";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path={"/todo"} element={<TodoLayout/>}>
            <Route index element={<TodoList/>}/>
            <Route path={"/todo/add-todo"} element={<AddTodo/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
