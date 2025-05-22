import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';
import apiClient from './api/clientInstance';
import { setBuyList } from './searchSlice';

export default function ViewBuyHistory() {
	const dispatch = useDispatch();
	const {userid} = useParams();
	const buyList = useSelector((state) => state.userSearch.buyList.filter((t) => t.userid === userid));

	useEffect(() => {
		const fetchData = async () => {
			try {
				const response = await apiClient.get(`/buy-history/${userid}`);
				dispatch(setBuyList(response.data));
			} catch(error) {
				console.log(error);
			}
		};

		if (userid) {
			fetchData();
		}
	}, [userid, dispatch]);

	return (
		<>
		<section>
			<h2>{userid}님의 구매이력</h2>
			<ul className='userinfo-list'>
				{buyList.map((buy) => (
				<li key={buy.id}>
					<p><span>상품명</span> {buy.prodname}</p>
					<p><span>카테고리</span> {buy.groupname}</p>
					<p><span>가격</span> {buy.price}</p>
					<p><span>수량</span> {buy.amount}</p>
				</li>
				))}
			</ul>
    	</section>
		</>
	);
}