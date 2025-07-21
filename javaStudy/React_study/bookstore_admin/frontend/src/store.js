import {configureStore, createSlice} from "@reduxjs/toolkit";

const madangInfoSlice = createSlice({
    name: "madangInfo",
    initialState: {
        orderList: [],
    },
    reducers: {
        setOrderList: (state, action) => {
            state.orderList = action.payload;
        },
    }
});


const store = configureStore({
   reducer: {
       madangInfo: madangInfoSlice.reducer,
   }
});

const {setOrderList,} = madangInfoSlice.actions;
export default store;