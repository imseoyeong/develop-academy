import {configureStore, createSlice} from "@reduxjs/toolkit";

const todoSilice = createSlice({
    name: "todo",
    initialState: {
        todoList: [],
    },
    reducers: {
        setTodoList: (state, action) => {
            state.todoList = action.payload;
        },
        updateTodoList: (state, action) => {
            state.todoList = state.todoList.map(todo =>
                todo.id === action.payload.id ? action.payload : todo
            );
        },
        deleteTodo: (state) => {
            state.todoList = state.todoList.filter(todo => !todo.completed);
        },
    },
});

const store = configureStore({
    reducer: {
        todo: todoSilice.reducer,
    }
})

export const {setTodoList, updateTodoList, deleteTodo} = todoSilice.actions;
export default store;