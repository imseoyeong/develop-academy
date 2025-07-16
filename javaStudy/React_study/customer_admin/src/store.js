import {configureStore, createSlice} from "@reduxjs/toolkit";

const userInfoSlice = createSlice({
    name: "userInfo",
    initialState: {
        userInfoList: [],
        token: null,
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
    },
});


const tokenSlice = createSlice({
    name:"token",
    initialState: {
        token :null,
    },
    reducers:{
        setToken:(state, action)=>{
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

export const {setUserInfoList, addUserInfo, clearUserInfo} = userInfoSlice.actions;
export const {setToken} = tokenSlice.actions;
export default store;