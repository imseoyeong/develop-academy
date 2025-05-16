import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { productAdd } from "./productSlice";
import { useRef} from "react";
import apiClient from "./api/clientInstance";

export default function NewProduct(){
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async e=>{
        e.preventDefault();
		const p = {title: e.target.title.value, price: Number(e.target.price.value)};

		try {
			const response = await apiClient.post("/new-product", p);
			dispatch(productAdd(response.data));
		} catch(error) {
			console.log(error);
		}

		// fetch("http://localhost:8080/new-product", {
		// 	method: "POST",
		// 	headers: {
		// 		"Content-Type": "application/json"
		// 	},
		// 	body: JSON.stringify(p),
		// })
		// .then(response => {
		// 	if (!response.ok) {
		// 		throw new Error("네트워크 오류");
		// 	}
		// 	return response.json();
		// })
		// .then(data => {
		// 	dispatch(productAdd(data));
		// })
		// .catch(error => {
		// 	console.log(error);
		// });

        navigate("/");
    }

    return (
        <>
        <h2>New Product</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="title"></input>
                <input type="text" name="price"></input>
                <button type="submit">저장</button>
            </form>

        </>
    );
}