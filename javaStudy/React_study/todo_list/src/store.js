import {configureStore, createSlice} from "@reduxjs/toolkit";

const todoSilice = createSlice({
    name: "todo",
    initialState:{
        todoList: [],
    },
    reducers: {
        setTodoList: (state, action) => {
            state.todoList = action.payload;
        },
        // completeTodoList:
    },
});

const store = configureStore({
    reducer: {
        todo: todoSilice.reducer,
    }
})

export const {setTodoList} = todoSilice.actions;
export default store;