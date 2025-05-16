import {useDispatch, useSelector} from "react-redux";
import {productDelete} from "./productSlice";
import { Link } from "react-router-dom";
import apiClient from "./api/clientInstance";
export default function List(){
    const pdList = useSelector(state=>state.product.productList);
    const dispatch = useDispatch();

    const handleDelete = async (e)=>{
		try {
			const response = await apiClient.delete("/product/" + e.target.id);
			dispatch(productDelete(e.target.id));
			console.log(response.data);
		} catch(error) {
			console.log(error);
		}

		// fetch("http://localhost:8080/product/" + e.target.id, {
		// 	method: "DELETE",
		// })
		// .then(response => {
		// 	if (!response.ok) {
		// 		throw new Error("네트워크 오류");
		// 	}
		// 	return response.text(); // String으로 보냈기 때문에 json아니고 text
		// })
		// .then(data => {
		// 	// 그냥 dispatch만 쓰면 상품 삭제 성공했을 때 실패했을 때 두 가지 경우 다 들어옴. => if문으로 먼저 확인하기
		// 	if (data === "Product deleted successfully") {
		// 		dispatch(productDelete(e.target.id));
		// 		console.log(data);
		// 	} else {
		// 		console.log(data);
		// 	}
		// })
		// .catch(error => {
		// 	console.log(error);
		// });
    };

    const list = pdList.map(t=>(
        <div key={t.id}>
            <br/>
            <Link to={"/detail-product/"+t.id}><img src={t.imagesrc}/></Link>
            <h3>{t.title}</h3>
            <Link to={"/edit-product/"+t.id}> 🖋 </Link>
            <span id={t.id} onClick={handleDelete}>🗑</span>
            <br/><br/>
        </div>
    ));
    
    return (
        <>
            {list}
        </>
    );
}