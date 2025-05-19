import { createSlice } from '@reduxjs/toolkit';

const todoListSlice = createSlice({
    name: "todoList",
    initialState: {
        todoList: [],
    },
    reducers: {
        onSave: (state, action) => {
			state.todoList.push(action.payload);
        },
        onDelete: (state, action) => {
            // state.todoList = state.todoList.filter((todo) => Number(todo.id) !== Number(action.payload));
			state.todoList = state.todoList.filter((todo) => !todo.isDone);
        },
		onToggleDone: (state, action) => {
			const todo = state.todoList.find(todo => Number(todo.id) === Number(action.payload));
			if (todo) {
				todo.isDone = !todo.isDone;
			}
		},
    },
});

export const { onSave, onDelete, onToggleDone } = todoListSlice.actions;
export default todoListSlice;