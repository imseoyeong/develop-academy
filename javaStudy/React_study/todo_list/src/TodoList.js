import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import apiClient from "./api/axiosInstance";
import {deleteTodo, setTodoList, updateTodoList} from "./store";

export default function TodoList() {
    const todoList = useSelector(state => state.todo.todoList);
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await apiClient.get("/todo-list");
                dispatch(setTodoList(response.data));
            } catch (error) {
                console.log(error);
            }
        }
        fetchData();
    }, []);

    const handleComplete = async (id) => {
        try {
            const response = await apiClient.put(`/todo/${id}`, {
                completed: true,
            });
            dispatch(updateTodoList(response.data));
        } catch (error) {
            console.log(error);
        }
    }

    const handleDelete = async () => {
        try {
            const response = await apiClient.delete("/completed-todo");
            dispatch(deleteTodo(response.data));
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <>
        <section>
            <h2>TODO 목록</h2>

            <ul>
                {todoList.map(t =>
                <li key={t.id}>
                    <span style={{textDecoration: t.completed ? "line-through" : "none"}}>{t.title}</span>
                    <button type={"button"} onClick={() => {handleComplete(t.id)}}>완료</button>
                </li>
                )}
            </ul>

            <button type={"button"} onClick={handleDelete}>완료 TODO 삭제</button>
        </section>
        </>
    );
}