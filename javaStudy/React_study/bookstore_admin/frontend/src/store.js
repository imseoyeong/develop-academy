import {configureStore, createSlice} from "@reduxjs/toolkit";

const madangInfoSlice = createSlice({
    name: "madangInfo",
    initialState: {
        orderList: [],
        bookInfo: null,
    },
    reducers: {
        setOrderList: (state, action) => {
            state.orderList = action.payload;
        },
        setBookInfo: (state, action) => {
            state.bookInfo = action.payload;
        },
    }
});


const store = configureStore({
    reducer: {
        madangInfo: madangInfoSlice.reducer,
    }
});

export const {setOrderList, setBookInfo} = madangInfoSlice.actions;
export default store;