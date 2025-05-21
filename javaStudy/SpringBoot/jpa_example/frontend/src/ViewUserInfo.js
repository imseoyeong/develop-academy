import { useSelector } from 'react-redux';

export default function ViewUserInfo() {
	const userList = useSelector((state) => state.userSearch.userList);

	return (
		<>
		<section>
			<h3>검색 결과</h3>
			<ul>
				{userList.map((user) => (
				<li key={user.id}>
					<p>아이디: {user.userid}</p>
					<p>이름: {user.username}</p>
					<p>출생년도: {user.birthyear}</p>
					<p>지역: {user.addr}</p>
					<p>전화번호: {user.mobile1}{user.mobile2}</p>
					<p>키: {user.height}</p>
					<p>가입날짜: {user.mdate}</p>
				</li>
				))}
			</ul>
    	</section>
		</>
	);

}