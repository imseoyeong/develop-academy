import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import apiClient from "./api/axiosInstance";
import {setTodoList} from "./store";

export default function AddTodo() {
    const todoList = useSelector(state => state.todo.todoList);
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await apiClient.post("/todo", {
                title: e.target.title.value
            });

            dispatch(setTodoList([...todoList, response.data]));
            navigate("/todo");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <>
            <h2>TODO 추가</h2>

            <form onSubmit={handleSubmit}>
                <input type={"text"} placeholder={"TODO를 입력해주세요"} name={"title"}/>
                <button type={"submit"}>ADD TODO</button>
            </form>
        </>
    );
}