import { useDispatch, useSelector } from 'react-redux';
import { onDelete } from './todoListSlice';

export default function TodoList() {
    const todoList = useSelector((state) => state.todoList.todoList);
    const item = useSelector((state) => state.todoList.todoList);
    const dispatch = useDispatch();

    return (
        <>
        <ul>
            {todoList.map((todo) => (
                <li>
                    {todo.todoInput}
                    <button type='button' onClick={() => {
                        dispatch(onDelete(todo.id));
                    }}>Delete</button>
                </li>
            ))}
        </ul>
        </>
    );
}