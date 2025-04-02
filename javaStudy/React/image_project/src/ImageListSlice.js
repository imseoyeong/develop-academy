import { createSlice } from '@reduxjs/toolkit';

import africa from "./img/africa.jpg";
import brazil from "./img/brazil.jpg";
import canada from "./img/canada.jpg";
import cuba from "./img/cuba.jpg";

const imageListSlice = createSlice({
    name: "ShowImage",
    initialState: {
        imageList: [
            { id: 1, src: africa, desc: "아프리카", link: "/africa" },
            { id: 2, src: brazil, desc: "브라질", link: "/brazil" },
            { id: 3, src: canada, desc: "캐나다", link: "/canada" },
            { id: 4, src: cuba, desc: "쿠바", link: "/cuba" },
        ],
    },
    reducers: {},
});

export default imageListSlice;