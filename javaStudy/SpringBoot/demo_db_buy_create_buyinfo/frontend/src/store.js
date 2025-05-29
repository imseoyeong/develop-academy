import {createSlice, configureStore} from "@reduxjs/toolkit";

const userInfoSlice=createSlice({
    name:"userInfo",
    initialState:{
        userInfoList:[],
        count:0
    },
    reducers:{
        addUserInfo:(state, action)=>{
            state.userInfoList.push(action.payload);
            state.count++;
        },
        setUerInfoList:(state, action)=>{
          state.userInfoList=action.payload;
          state.count=action.payload.length;
        },
        clearUserInfo:(state)=>{
            state.userInfoList=[];
            state.count=0;
        }
    }
});

const authSlice = createSlice({
    name: "auth",
    initialState: {
        isLogin: false,
        username: null
    },
    reducers: {
        login: (state, action) => {
            state.isLogin = true;
            state.username = action.payload;
        },
        logout: (state) => {
            state.isLogin = false;
            state.username = null;
        }
    }
});

const store=configureStore({
    reducer:{
        userInfo:userInfoSlice.reducer,
        auth: authSlice.reducer,
    }
});

export const {addUserInfo,clearUserInfo, setUerInfoList }=userInfoSlice.actions;
export const {login, logout} = authSlice.actions;
export default store;