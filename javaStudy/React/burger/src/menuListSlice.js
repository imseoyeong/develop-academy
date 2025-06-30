import {createSlice} from "@reduxjs/toolkit";

const menuListSlice = createSlice({
    name: "menuList",
    initialState: {
        menu: [
            {id: 1, src: "/img/burger.png", title: "Burger"},
            {id: 2, src: "/img/side.png", title: "Side"},
            {id: 3, src: "/img/cafe.png", title: "Cafe"}
        ]
    },
});

export default menuListSlice;