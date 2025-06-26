import logo from './logo.svg';
import './App.css';
import {useState} from "react";
import TodoBoard from "./component/TodoBoard";

function App() {
    const [inputValue, setInputValue] = useState('');
    const [todoList, setTodoList] = useState([]);

    const addItem = (e) => {
        console.log("im here!", inputValue);
        setTodoList([...todoList, inputValue]);
    }

    const removeItem = (e) => {
        setTodoList(todoList.slice(0, -1));
    }


    return (
        <>
            <input type={"text"} value={inputValue} onChange={(e) => setInputValue(e.target.value)} />
            <button onClick={addItem}>추가</button>
            <button onClick={removeItem}>삭제</button>


            <TodoBoard todoList={todoList} setTodoList={setTodoList}/>
        </>
    );
}

export default App;
