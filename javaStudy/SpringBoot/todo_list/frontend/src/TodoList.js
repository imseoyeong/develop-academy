import { useDispatch, useSelector } from 'react-redux';
import { onDelete, onToggleDone } from './todoListSlice';
import apiClient from './api/clientInstance';

export default function TodoList() {
    const todoList = useSelector((state) => state.todoList.todoList);
    const dispatch = useDispatch();

	const handleToggleDone = async (id) => {
		dispatch(onToggleDone(id));
	}

    return (
        <>
        <ul>
            {todoList.map((todo) => (
                <li key={todo.id} style={{textDecoration: todo.isDone ? 'line-through' : 'none'}}>
                    {todo.content}
                    <button type='button' onClick={() => handleToggleDone(todo.id)}>완료</button>
                    {/* <button type='button' onClick={() => handleDelete(todo.id)}>Delete</button> */}
                </li>
            ))}
        </ul>
        </>
    );
}