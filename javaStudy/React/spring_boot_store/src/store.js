import { configureStore } from '@reduxjs/toolkit';
import productSlice from './productSlice';

const store = configureStore({
    reducer: {
        productList: productSlice.reducer,
    },
});

export default store;