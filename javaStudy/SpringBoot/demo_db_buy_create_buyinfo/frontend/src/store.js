import {createSlice, configureStore} from "@reduxjs/toolkit";

const userInfoSlice = createSlice({
    name: "userInfo",
    initialState: {
        userInfoList: [],
        count: 0,
        isLogin: false,
        username: null,
        token: null,
        role: null,
    },
    reducers: {
        addUserInfo: (state, action) => {
            state.userInfoList.push(action.payload);
            state.count++;
        },
        setUserInfoList: (state, action) => {
            state.userInfoList = action.payload;
            state.count = action.payload.length;
        },
        clearUserInfo: (state) => {
            state.userInfoList = [];
            state.count = 0;
        },
        login: (state, action) => {
            state.isLogin = true;
            state.username = action.payload;
            state.role = action.payload.role;
        },
        logout: (state) => {
            state.isLogin = false;
            state.username = null;
            state.role = null;
        },
        setToken: (state, action) => {
            state.token = action.payload;
        },
        setRole: (state, action) => {
            state.role = action.payload;
        }
    }
});


const store = configureStore({
    reducer: {
        userInfo: userInfoSlice.reducer,
    }
});

export const {addUserInfo, clearUserInfo, setUserInfoList, login, logout, setToken, setRole} = userInfoSlice.actions;
export default store;