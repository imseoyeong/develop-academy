import {createSlice} from "@reduxjs/toolkit";

const boardListSlice = createSlice({
    name: "boardList",
    initialState: {
        boardItem: [],
        commentItem: [],
    },
    reducers: {
        setBoardItem:(state, action)=>{
            state.boardItem = action.payload;
        },
        addItem: (state, action) => {
            state.boardItem.push(action.payload);
        },
        removeItem: (state, action) => {
            state.boardItem = state.boardItem.filter((item) => item.postId !== action.payload);
        },
        updateItem: (state, action) => {
            state.boardItem = state.boardItem.map((item) => item.postId === action.payload.postId ? action.payload : item);
        },
        addComment: (state, action) => {
            state.commentItem.push(action.payload);
        }
    }
});

export const {addItem, removeItem, updateItem, setBoardItem, addComment} = boardListSlice.actions;
export default boardListSlice;
