import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import apiClient from "./api/axiosInstance";
import {setTodoList} from "./store";

export default function TodoList() {
    const todoList = useSelector(state => state.todo.todoList);
    // const completeTodo = useSelector(state => state.todo.todoList.find( = id))
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

    const handleComplete = () => {

    }

    return (
        <>
        <section>
            <h2>TODO 목록</h2>

            <ul>
                {todoList.map(t =>
                <li key={t.id}>
                    <p>{t.title}</p>
                    <button type={"button"} onClick={handleComplete}>완료</button>
                </li>
                )}
            </ul>

            <button type={"button"}>완료 TODO 삭제</button>
        </section>
        </>
    );
}