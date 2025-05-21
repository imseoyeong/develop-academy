import {configureStore} from "@reduxjs/toolkit";
import searchSlice from "./searchSlice";

const store = configureStore({
    reducer: {
        userSearch: searchSlice.reducer,
    }
});

export default store;