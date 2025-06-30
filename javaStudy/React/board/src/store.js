import {configureStore} from "@reduxjs/toolkit";
import boardListSlice from "./boardListSlice";

const store = configureStore({
   reducer: {
      boardList: boardListSlice.reducer,
   }
});

export default store;