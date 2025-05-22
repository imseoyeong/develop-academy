import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

export default function ViewUserInfo() {
	const userList = useSelector((state) => state.userSearch.userList);

	return (
		<>
		<section>
			<h2>검색 결과</h2>
			<ul className='userinfo-list'>
				{userList.map((user) => (
				<li key={user.id}>
					<p><span>아이디</span> {user.userid}</p>
					<p><span>이름</span> {user.username}</p>
					<p><span>출생년도</span> {user.birthyear}</p>
					<p><span>지역</span> {user.addr}</p>
					<p><span>전화번호</span> {user.mobile1}{user.mobile2}</p>
					<p><span>신장</span> {user.height}</p>
					<p><span>가입일자</span> {user.mdate}</p>
					<Link to={"/view-buyhistory/" + user.userid}>구매이력 보기</Link>
				</li>
				))}
			</ul>
    	</section>
		</>
	);

}