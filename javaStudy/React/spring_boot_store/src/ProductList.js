import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { onDelete } from './productSlice';

export default function ProductList() {
	const dispatch = useDispatch();
	const navigate = useNavigate();
	const productList = useSelector((state) => state.productList.itemList);
	const list = [];

	for (let product of productList) {
		const item = <li key = {product.id}>
			<Link to={"/list/" + product.id}>
                <img className='product-img' src={product.img} alt={product.subject} />
			</Link>
			<div className='info'>
				<h4 className='subject'>{product.subject}</h4>
				<div className='modi-menu'>
					<Link className='btn' to={"/update/" + product.id}>수정</Link>
					<button className='btn btn-bdr' onClick={(e) => {
						dispatch(onDelete({ id: product.id }));
						navigate("/");
					}}>삭제</button>
				</div>
			</div>
		</li>
		list.push(item);
	}

	return (
		<>
		<section>
			<ul className='product-list'>
				{list}
			</ul>
		</section>
		</>
	);
}