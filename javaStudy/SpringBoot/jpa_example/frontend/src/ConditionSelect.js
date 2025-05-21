import { Outlet, useNavigate } from 'react-router-dom';
import { useDispatch } from "react-redux";
import { useState } from 'react';
import { onSelect } from './searchSlice';

export default function ConditionSelect() {
	const dispatch = useDispatch();
	const navigate = useNavigate();

	const [selected, setSelected] = useState([]);

	const handleCheckChange = (e) => {
		const { id, checked } = e.target;

		if (checked) {
			setSelected([...selected, id]);
		} else {
			setSelected(selected.filter((item) => item !== id));
		}
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		dispatch(onSelect(selected));
		navigate("/search/detail-condition");
	};

	return (
		<>
		<form onSubmit={handleSubmit}>
			<div className='select-wrap'>
				<ul className='select-list'>
					<li>
						<input id='addr' name='search' type='checkbox' onChange={handleCheckChange}/>
						<label for='addr'>지역</label>
					</li>
						<li>
						<input id='birthyear' name='search' type='checkbox' onChange={handleCheckChange}/>
						<label for='birthyear'>출생년도</label>
					</li>
				</ul>
				<button type='submit'>선택하기</button>
			</div>
			
			<Outlet/>
		</form>
		</>
	);
}