import {configureStore, createSlice} from "@reduxjs/toolkit";

const userInfoSlice = createSlice({
    name: "userInfo",
    initialState: {

    },
    reducers: {

    },
});

const store = configureStore({
    reducer: {
        userInfo: userInfoSlice.reducer,
    }
});

export default store;