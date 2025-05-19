import { useEffect, useState } from 'react';
import { Outlet } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { onDelete, onSave } from './todoListSlice';
import apiClient from './api/clientInstance';


export default function MainLayout() {
    const dispatch = useDispatch();
	const todoList = useSelector(state => state.todoList.todoList);

	useEffect(() => {
		const fetchData = async () => {
			try {
				const response = await apiClient.get("/todo-list")
				response.data.map(p => dispatch(onSave(p)));
			} catch(error) {
				console.log(error);
			}
		}
		fetchData();
	}, []);

	const handleSubmit = async (e) => {
		e.preventDefault();
		const p = {content: e.target.content.value};

		try {
			const response = await apiClient.post("/add-todo", p);
			dispatch(onSave(response.data));
		} catch(error) {
			console.log(error);
		}
	}

	const handleDelete = async () => {
		const doneTodos = todoList.filter(todo => todo.isDone);
		for (const todo of doneTodos) {
			try {
				await apiClient.delete("/todo/" + todo.id);
				dispatch(onDelete(todo.id));
			} catch(error) {
				console.log(error);
			}
		}

	};

    return (
        <>
        <h1>ToDo List</h1>
        <form onSubmit={handleSubmit}>
            <input type='text' name='content' placeholder='Todo를 작성해 주세요.'></input>
            <button type='submit'>Add Todo</button>
        </form>
        <Outlet/>
        <button type='button' onClick={handleDelete}>완료 항목 삭제</button>
        </>
    );
}