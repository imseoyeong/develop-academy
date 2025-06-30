import {createSlice} from "@reduxjs/toolkit";

const boardListSlice = createSlice({
    name: "boardList",
    initialState: {
        boardItem: [
            {id: 1, title: "안녕하세요", content: "게시판 내용입니당", writer: "임서영"},
            {id: 2, title: "헬로헬로", content: "게시판 내용입니당당", writer: "홍길동"},
        ],
        nextId: 3,
    },
    reducers: {
        addItem: (state, action) => {
            state.boardItem.push({...action.payload, id: state.nextId});
            state.nextId++;
        },
    }
});

export const {addItem} = boardListSlice.actions;
export default boardListSlice;