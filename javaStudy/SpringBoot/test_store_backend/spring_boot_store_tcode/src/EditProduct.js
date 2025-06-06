import { useNavigate, useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { useState } from "react";
import { productUpdate } from "./productSlice";
import apiClient from "./api/clientInstance";

export default function EditProduct() {
  const { id } = useParams();
  const dispatch = useDispatch();
  const product = useSelector((state) =>
    state.product.productList.find((t) => t.id === Number(id))
  );
  const [state, setState] = useState(product);
  const navigate = useNavigate();

  const handleSubmit = async e=>{
    e.preventDefault();
	const p = {id: product.id, price: state.price}; // Number(e.target.price.value)라고 해도 가능

	try {
		const response = await apiClient.put("/product", p);
		dispatch(productUpdate(response.data));
	} catch(error) {
		console.log(error);
	}

	// fetch("http://localhost:8080/product", {
	// 	method: "PUT",
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
	// 	dispatch(productUpdate(data));
	// })
	// .catch(error => {
	// 	console.log(error);
	// });
	
    navigate("/");
  }

  return (
    <>
      {product && (
        <div>
          <h2>Edit Product</h2>
          <img src={state.imagesrc}></img>
          <form onSubmit={handleSubmit}>
            {state.title}<br/>
            <input type="text" name="price" value={state.price || ""}
             onChange={e=>setState(s=>({...s, price : Number(e.target.value)}))}/>
            <button type="submit">저장</button>
          </form>
        </div>
      )}
    </>
  );
}
