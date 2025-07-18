import {configureStore, createSlice} from "@reduxjs/toolkit";

const userInfoSlice = createSlice({
    name: "userInfo",
    initialState: {
        userInfoList: [],
        token: null,
        adminLoginFlag: false,
        userLoginFlag: false,
    },
    reducers: {
        setUserInfoList: (state, action) => {
            state.userInfoList = action.payload;
        },
        addUserInfo: (state, action) => {
            state.userInfoList.push(action.payload);
        },
        clearUserInfo: (state) => {
            state.userInfoList = [];
        },
        adminLogin: (state) => {
            state.adminLoginFlag = true;
        },
        userLogin: (state) => {
            state.userLoginFlag = true;
        },
        logout: (state) => {
            state.adminLoginFlag = false;
            state.userLoginFlag = false;
        },
    },
});


const tokenSlice = createSlice({
    name: "token",
    initialState: {
        token: null,
    },
    reducers: {
        setToken: (state, action) => {
            state.token = action.payload;
        }
    }
});

const store = configureStore({
    reducer: {
        userInfo: userInfoSlice.reducer,
        token: tokenSlice.reducer,
    }
});

export const {
    setUserInfoList, addUserInfo, clearUserInfo,
    adminLogin, userLogin, logout
} = userInfoSlice.actions;
export const {setToken} = tokenSlice.actions;
export default store;