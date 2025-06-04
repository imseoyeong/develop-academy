import {createSlice, configureStore} from "@reduxjs/toolkit";

const userInfoSlice=createSlice({
    name:"userInfo",
    initialState:{
        userInfoList:[],
        adminLoginFlag:false,
        userLoginFlag:false
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

    }
});


const initState={
    token:null,
}

const tokenSlice = createSlice({
    name:"token",
    initialState:initState,
    reducers:{
        setToken:(state, action)=>{
            state.token= action.payload;
        }
    }
});




const store=configureStore({
    reducer:{
        userInfo:userInfoSlice.reducer,
        token:tokenSlice.reducer
    }
});

export const {userLogin, userLogout, addUserInfo,clearUserInfo, setUerInfoList, adminLogin, adminLogout}=userInfoSlice.actions;
export const {setToken} = tokenSlice.actions;
export default store;