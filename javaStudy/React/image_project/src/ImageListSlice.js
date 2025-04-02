import { createSlice } from '@reduxjs/toolkit';

const initState = [
    { id: 1, src: "/img/africa.jpg", desc: "아프리카" },
    { id: 2, src: "./img/brazil.jpg", desc: "브라질" },
    { id: 3, src: "./img/canada.jpg", desc: "캐나다" },
    { id: 4, src: "./img/cuba.jpg", desc: "쿠바" },
];

const ImageListSlice = createSlice({
    name: "ShowImage",
    initialState: {
        imageList: initState,
    },
});

// export const { onSave, onDelete } = ImageListSlice.actions;
export default ImageListSlice;