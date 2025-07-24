import {combineReducers, configureStore, createSlice} from "@reduxjs/toolkit";
import storage from "redux-persist/lib/storage";
import {persistReducer, persistStore} from "redux-persist";

const userInfoSlice = createSlice({
    name: "userInfo",
    initialState: {
        userInfoList: [],
        token: null,
        adminLoginFlag: false,
        userLoginFlag: false,
    },
    reducers: {
        setUserInfoList: (state, action) => {
            state.userInfoList = action.payload;
        },
        addUserInfo: (state, action) => {
            state.userInfoList.push(action.payload);
        },
        clearUserInfo: (state) => {
            state.userInfoList = [];
        },
        adminLogin: (state) => {
            state.adminLoginFlag = true;
        },
        userLogin: (state) => {
            state.userLoginFlag = true;
        },
        logout: (state) => {
            state.adminLoginFlag = false;
            state.userLoginFlag = false;
        },
    },
});


const tokenSlice = createSlice({
    name: "token",
    initialState: {
        token: null,
    },
    reducers: {
        setToken: (state, action) => {
            state.token = action.payload;
        }
    }
});

const persistConfig = {
    key: "root",
    storage,
    whitelist: ["userInfo", "token"],
}

const rootReducer = combineReducers({
    userInfo: userInfoSlice.reducer,
    token: tokenSlice.reducer,
})

const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
    reducer: persistedReducer,
});

export const persistor = persistStore(store);

export const {
    setUserInfoList, addUserInfo, clearUserInfo,
    adminLogin, userLogin, logout
} = userInfoSlice.actions;
export const {setToken} = tokenSlice.actions;
export default store;