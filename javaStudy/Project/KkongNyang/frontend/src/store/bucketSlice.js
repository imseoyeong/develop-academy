import {createSlice} from "@reduxjs/toolkit";

const bucketSlice = createSlice ({
    name: "bucket",
    initialState: {
        bucketList: [],
    },
    reducers: {
        setBucketList: (state, action) => {
            state.bucketList = action.payload;
        },
        addBucket: (state, action) => {
            state.bucketList.push(action.payload);
        },
        removeBucket: (state, action) => {
            state.bucketList.filter(bucket => bucket.id !== action.payload.id);
        }
    }
})

export  const {addBucket, setBucketList, removeBucket} = bucketSlice.actions;
export default bucketSlice;