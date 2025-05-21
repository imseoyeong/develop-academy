import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import apiClient from "./api/clientInstance";
import { setUserList } from './searchSlice';

export default function DetailCondition() {
	const selected = useSelector((state) => state.userSearch.selectedConditions);
	const dispatch = useDispatch();
	const navigate = useNavigate();

	const [addr, setAddr] = useState('');
	const [birthyear, setBirthyear] = useState('');

	const handleSearch = async (e) => {
		e.preventDefault();

		try {
			let response;

			if (addr && !birthyear) { // 지역만 선택
				response = await apiClient.get(`/addr/${addr}`);
			} else if (!addr && birthyear) { // 출생년도만 선택
				response = await apiClient.get(`/birthyear/${birthyear}`);
			} else if (addr && birthyear) {
				response = await apiClient.get(`/addr-birthyear`, {params: {addr, birthyear}});
			} else {
				return;
			}
			
			dispatch(setUserList(response.data));
			navigate('/view-userinfo');
		} catch(error) {
			console.log(error);
		}
	}

	return (
		<>
		<div>
			<ul>
				{selected.includes('addr') && (
				<li>
					<label for='addr'>지역</label>
					<input id='addr' type='text' value={addr} onChange={(e) => setAddr(e.target.value)} />
				</li>
				)}

				{selected.includes('birthyear') && (
				<li>
					<label for='birthyear'>출생년도</label>
					<input id='birthyear' type='text' value={birthyear} onChange={(e) => setBirthyear(e.target.value)}/>
				</li>
				)}
			</ul>
			<button onClick={handleSearch}>검색</button>
		</div>
		</>
	);
}