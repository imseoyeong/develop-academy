import {createSlice} from "@reduxjs/toolkit";

const userListSlice = createSlice({
    name: "userList",
    initialState: {
        users: [],
        userLoginFlag: false,
        currentUser: null,
        token: null,
    },
    reducers: {
        addUsers: (state, action) => {
            state.users.push(action.payload);
        },
        userLogin: (state, action) => {
            state.userLoginFlag = true;
            state.currentUser = action.payload;
        },
        userLogout: (state) => {
            state.userLoginFlag = false;
            state.currentUser = null;
        },
        setToken: (state, action) => {
            state.token = action.payload;
        }
    }
});

export const {addUsers, userLogin, userLogout, setToken} = userListSlice.actions;
export default userListSlice;
