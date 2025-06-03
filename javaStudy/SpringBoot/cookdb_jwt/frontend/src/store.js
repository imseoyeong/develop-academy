import {createSlice, configureStore} from "@reduxjs/toolkit";

const userInfoSlice=createSlice({
    name:"userInfo",
    initialState:{
        userInfoList:[],
        adminLoginFlag:false,
        userLoginFlag:false,
        csrfToken:null,
        issuanceToken:null,
    },
    reducers:{
        addUserInfo:(state, action)=>{
            state.userInfoList.push(action.payload);
        },
        setUerInfoList:(state, action)=>{
          state.userInfoList=action.payload;
          state.count=action.payload.length;
        },
        clearUserInfo:(state)=>{
            state.userInfoList=[];
        },
        adminLogin: (state) => {
            state.adminLoginFlag = true;
        },
        adminLogout: (state) => {
            state.adminLoginFlag = false;
        },
        userLogin:(state)=>{
            state.userLoginFlag = true;
        },
        userLogout:(state)=>{
            state.userLoginFlag = false;
        },
        saveCsrfToken:(state, action)=>{
            state.csrfToken=action.payload;
        },
        setIssuanceToken:(state, action)=>{
            state.issuanceToken = action.payload;
        }
    }
});

const store=configureStore({
    reducer:{
        userInfo:userInfoSlice.reducer,
    }
});

export const {userLogin, userLogout, addUserInfo,clearUserInfo, setIssuanceToken, setUerInfoList, adminLogin, adminLogout, saveCsrfToken}=userInfoSlice.actions;
export default store;