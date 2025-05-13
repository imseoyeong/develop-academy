import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
import { onUpdate } from './productSlice';
import { useState } from 'react';

export default function ProductDetails() {
	const dispatch = useDispatch();
    const navigate = useNavigate();
	const { productid } = useParams();
	const productList = useSelector((state) => state.productList.itemList);

	const product = productList.find(p => p.id === parseInt(productid));

	const [price, setPrice] = useState(product? product.price: "");

	return (
		<>
		<form onSubmit={(e) => e.preventDefault()}>
			<div className='product-details'>
				<img className='product-img' src={product.img} alt={product.subject} />
				<h4 className='subject'>{product.subject}</h4>
				<input type='text' name='price' placeholder='가격을 입력하세요' value={price} onChange={(e)=>{
					setPrice(e.target.value);
				}} />
				<div className='btn-wrap'>
					<button onClick={(e) => {
						dispatch(onUpdate({ id: product.id, subject: product.subject, img: product.img, price: parseInt(price) }));
						navigate("/")
					}} className='btn'>수정</button>
				</div>
			</div>
		</form>
		</>
	);
}