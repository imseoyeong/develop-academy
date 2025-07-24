import {combineReducers, configureStore, createSlice} from "@reduxjs/toolkit";
import {persistReducer, persistStore} from "redux-persist";
import storage from "redux-persist/lib/storage";

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

const persistConfig = {
    key: "root",
    storage,
    whitelist: ["todo"],
}

const rootReducer = combineReducers({
    todo: todoSilice.reducer,
});

const persistedReducer  = persistReducer(persistConfig, rootReducer);

const store = configureStore({
    reducer: persistedReducer,
});

export const persistor = persistStore(store);

export const {setTodoList, updateTodoList, deleteTodo} = todoSilice.actions;
export default store;