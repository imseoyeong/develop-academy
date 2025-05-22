import { Link, Outlet } from 'react-router-dom';

export default function AddUserInfo() {
	return (
		<>
		<ul className='menu-list small'>
			<li><Link to="/add-userinfo">가입 정보 추가</Link></li>
			<li><Link to="/add-userinfo/add-buyhistory">구매 기록 추가</Link></li>
		</ul>
		<Outlet/>
		</>
	);
}