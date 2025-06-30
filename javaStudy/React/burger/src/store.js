import {configureStore} from "@reduxjs/toolkit";
import menuListSlice from "./menuListSlice";

const store = configureStore({
    reducer: {
        menuList: menuListSlice.reducer,
    }
});

export default store;