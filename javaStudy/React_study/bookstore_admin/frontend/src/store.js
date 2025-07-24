import {combineReducers, configureStore, createSlice} from "@reduxjs/toolkit";
import storage from "redux-persist/lib/storage";
import {persistReducer, persistStore} from "redux-persist";

const madangInfoSlice = createSlice({
    name: "madangInfo",
    initialState: {
        orderList: [],
        bookInfo: null,
    },
    reducers: {
        setOrderList: (state, action) => {
            state.orderList = action.payload;
        },
        setBookInfo: (state, action) => {
            state.bookInfo = action.payload;
        },
    }
});

const persistConfig = {
    key: "root",
    storage,
    whitelist: ["madangInfo"],
}

const rootReducer = combineReducers({
    madangInfo: madangInfoSlice.reducer,
});

const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
    reducer: persistedReducer,
});

export const persistor = persistStore(store);

export const {setOrderList, setBookInfo} = madangInfoSlice.actions;
export default store;