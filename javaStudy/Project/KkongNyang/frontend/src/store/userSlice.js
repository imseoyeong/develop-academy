import {createSlice} from "@reduxjs/toolkit";

const userSlice = createSlice({
    name: "userInfo",
    initialState: {
        userList: [],
        userLoginFlag: false,
    },
    reducers: {
        addUser: (state, action) => {
            state.userList.push(action.payload);
        },
        userLogin: (state) => {
            state.userLoginFlag = true;
        }
    },
});

export const { addUser, userLogin } = userSlice.actions;
export default userSlice;