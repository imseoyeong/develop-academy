import {createSlice} from "@reduxjs/toolkit";

const userListSlice = createSlice({
    name: "userList",
    initialState: {
        users: [],
    },
    reducers: {
        addUsers: (state, action) => {
            state.users.push(action.payload);
        },
    }
});

export const {addUsers} = userListSlice.actions;
export default userListSlice;
