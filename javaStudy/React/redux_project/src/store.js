import { configureStore } from '@reduxjs/toolkit';
import counterSlice from './counterSlice';

const store = configureStore({
    reducer: {
        counter: counterSlice.reducer,
    },
});

export default store;
//변수를 만들어서 외부 제공할 때는 export 따로 작성