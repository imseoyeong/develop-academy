import TodoItem from "./TodoItem";

export default function TodoBoard(props) {
    const deleteItem = (i) => {
        props.setTodoList(prev => {
            return prev.filter((_, index) => index !== i)
        });
    }

    return (
        <>
            <h1>Todo List</h1>
            <ul>
                {props.todoList.map((item, index) => (
                <li key={index}>
                    {item}
                    <button onClick={() => deleteItem(index)}>삭제</button>
                </li>
                ))}
            </ul>

        </>
    );
}