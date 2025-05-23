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

const store=configureStore({
    reducer:{
        userInfo:userInfoSlice.reducer,
    }
});

export const {addUserInfo,clearUserInfo, setUerInfoList }=userInfoSlice.actions;
export default store;