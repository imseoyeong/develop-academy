import {configureStore} from "@reduxjs/toolkit";
import userSlice from "./userSlice";
import tokenSlice from "./tokenSlice";

const store = configureStore({
    reducer: {
        userInfo: userSlice.reducer,
        token: tokenSlice.reducer,
    }
});

export default store;