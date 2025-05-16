import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { onSave } from './productSlice';

export default function ProductForm() {
	const dispatch = useDispatch();
	const navigate = useNavigate();

	return (
		<>
		<form className='write-form' onSubmit={(e) => {
			e.preventDefault();
			const subject = e.target.subject.value;
			const price = e.target.price.value;
			const img = '/img/sample.jpg';
			dispatch(onSave({subject, price: parseInt(price), img}));
			navigate("/")
		}}>
			<h1>New Product</h1>
			<input type='text' name='subject' placeholder='상품명을 입력하세요'/>
            <input type='text' name='price' placeholder='가격을 입력하세요'/>
            <div className='btn-wrap'>
                <button type='submit' className='btn'>저장</button>
            </div>
		</form>
		</>
	);
}