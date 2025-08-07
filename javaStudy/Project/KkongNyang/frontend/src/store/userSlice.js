import {createSlice} from "@reduxjs/toolkit";

const userSlice = createSlice({
    name: "userInfo",
    initialState: {
        userInfo: null,
        coupleInfo: null,
        userLoginFlag: false,
        isCoupleMatched: false,
    },
    reducers: {
        userLogin: (state) => {
            state.userLoginFlag = true;
        },
        logout: (state) => {
            state.userLoginFlag = false;
        },
        addUser: (state, action) => {
            state.userInfo.push(action.payload);
        },
        setCoupleInfo: (state, action) => {
            state.coupleInfo = action.payload;
        },
        setUserInfo: (state, action) => {
            state.userInfo = action.payload;
        },
    },
});

export const { addUser, userLogin, logout, setCoupleInfo, setUserInfo } = userSlice.actions;
export default userSlice;