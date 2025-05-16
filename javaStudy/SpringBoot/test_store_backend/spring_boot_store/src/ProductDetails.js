import { useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';

export default function ProductDetails() {
	const { productid } = useParams();
	const productList = useSelector((state) => state.productList.itemList);

	const product = productList.find(p => p.id === parseInt(productid));

	if (!product) {
		return <p>해당 상품을 찾을 수 없습니다.</p>;
	}

	return (
		<>
		<section>
			<div className='product-details'>
				<img className='product-img' src={product.img} alt={product.subject} />
				<h4 className='subject'>{product.subject}</h4>
				<p className='price'>{product.price.toLocaleString()}원</p>
			</div>
		</section>
		</>
	);
}