import {configureStore} from "@reduxjs/toolkit";
import userSlice from "./userSlice";
import tokenSlice from "./tokenSlice";
import bucketSlice from "./bucketSlice";

const store = configureStore({
    reducer: {
        userInfo: userSlice.reducer,
        token: tokenSlice.reducer,
        bucket: bucketSlice.reducer,
    }
});

export default store;