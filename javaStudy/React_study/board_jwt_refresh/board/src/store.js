import {configureStore} from "@reduxjs/toolkit";
import boardListSlice from "./boardListSlice";
import userListSlice from "./userListSlice";

const store = configureStore({
   reducer: {
      boardList: boardListSlice.reducer,
      userList: userListSlice.reducer
   }
});

export default store;