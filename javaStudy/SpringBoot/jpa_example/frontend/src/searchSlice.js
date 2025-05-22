import {createSlice} from "@reduxjs/toolkit";

const searchSlice = createSlice({
    name: "userSearch",
    initialState: {
        userList: [],
		selectedConditions: [],
		buyList: []
    },
    reducers: {
		onSelect: (state, action) => {
			state.selectedConditions = action.payload; // ['addr', 'birthyear']
		},
		setUserList: (state, action) => {
			state.userList = action.payload;
		},
		setBuyList: (state, action) => {
			state.buyList = action.payload;
		},
		addUser: (state, action) => {
			state.userList.push(action.payload);
		}
    },
});

export const { onSelect, setUserList, setBuyList, addUser } = searchSlice.actions;
export default searchSlice;