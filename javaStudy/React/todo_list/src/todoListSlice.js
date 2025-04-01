import { createSlice } from '@reduxjs/toolkit';

const initState = [];

const todoListSlice = createSlice({
    name: "todoList",
    initialState: {
        todoList: initState,
        nextId: initState.length + 1,
    },
    reducers: {
        onSave: (state, action) => {
            state.todoList.push({ id: state.nextId, todoInput: action.payload });
            state.nextId++;
        },
        onDelete: (state, action) => {
            state.todoList = state.todoList.filter((todo) => todo.id !== action.payload);
        },
    },
});

export const { onSave, onDelete } = todoListSlice.actions;
export default todoListSlice;