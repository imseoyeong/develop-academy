import { useState } from 'react';
import { Outlet } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { onSave } from './todoListSlice';


export default function MainLayout() {
    const [ todoInput, setTodoInput] = useState("");
    const item = useSelector((state) => state.todoList.todoList);
    const dispatch = useDispatch();

    return (
        <>
        <h1>ToDo List</h1>
        <form>
            <input type='text' name='todoInput' value={todoInput} placeholder='Todo를 작성해 주세요.' onChange={(e) => {
                setTodoInput(e.target.value);
            }}></input>
            <button type='button' onClick={() => {
                //리덕스에 저장하기
                dispatch(onSave(todoInput));
            }}>Add Todo</button>
        </form>
        <Outlet/>
        </>
    );
}