import { configureStore } from '@reduxjs/toolkit';
import imageListSlice from './imageListSlice';

const store = configureStore({
    reducer: {
        ShowImage: imageListSlice.reducer,
    },
});

export default store;