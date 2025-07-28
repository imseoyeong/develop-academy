import {createSlice} from "@reduxjs/toolkit";

const boardListSlice = createSlice({
    name: "boardList",
    initialState: {
        boardItem: [],
    },
    reducers: {
        setBoardItem: (state, action) => {
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
            const {postId, newComment} = action.payload;
            const post = state.boardItem.find(item => item.postId === postId);

            if (post) {
                post.commentList.push(newComment);
            }
        },
        removeComment: (state, action) => {
            const {postId, commentId} = action.payload;
            const post = state.boardItem.find(item => item.postId === postId);

            if (post) {
                post.commentList = post.commentList.filter(comment => comment.id !== commentId);
            }
        },
    }
});

export const {addItem, removeItem, updateItem, setBoardItem, addComment, removeComment} = boardListSlice.actions;
export default boardListSlice;
