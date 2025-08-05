import {createSlice} from "@reduxjs/toolkit";

const userSlice = createSlice({
    name: "userInfo",
    initialState: {
        userList: [],
        coupleInfoList: [],
        userLoginFlag: false,
        isCoupleMatched: false,
    },
    reducers: {
        addUser: (state, action) => {
            state.userList.push(action.payload);
        },
        userLogin: (state) => {
            state.userLoginFlag = true;
        },
        coupleInfo: (state, action) => {
            state.coupleInfoList = action.payload;
        },

    },
});

export const { addUser, userLogin, coupleInfo } = userSlice.actions;
export default userSlice;