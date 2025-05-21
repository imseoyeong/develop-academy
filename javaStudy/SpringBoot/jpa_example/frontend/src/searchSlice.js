import {createSlice} from "@reduxjs/toolkit";

const searchSlice = createSlice({
    name: "userSearch",
    initialState: {
        userList: [],
		selectedConditions: [],
    },
    reducers: {
		onSelect: (state, action) => {
			state.selectedConditions = action.payload; // ['addr', 'birthyear']
		},
		setUserList: (state, action) => {
			state.userList = action.payload;
		}
		
    },
});

export const { onSelect, setUserList } = searchSlice.actions;
export default searchSlice;