import { createSlice } from '@reduxjs/toolkit';

const initState = [
	{ id: 1, subject: "상품1", img: "/img/sample.jpg", price: 10000},
	{ id: 2, subject: "상품2", img: "/img/sample.jpg", price: 15000},
	{ id: 3, subject: "상품3", img: "/img/sample.jpg", price: 23000},
];

const productSlice = createSlice({
	name: "productList",
	initialState: {
		itemList: initState,
		nextId: initState.length + 1,
  	},
	reducers: {
		onSave: (state, action) => {
			state.itemList.push({ ...action.payload, id: state.nextId });
			state.nextId++;
		},
		onUpdate: (state, action) => {
			for (let i = 0; i < state.itemList.length; i++) {
				if (state.itemList[i].id === action.payload.id) {
					state.itemList[i] = action.payload;
					break;
				}
			}
		},
		onDelete: (state, action) => {
			state.itemList = state.itemList.filter((product) => product.id !== action.payload.id);
		},
	},
});

export const { onSave, onUpdate, onDelete } = productSlice.actions;
export default productSlice;