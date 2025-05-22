import { Link } from 'react-router-dom';

export default function Header() {
	return (
		<>
		<header>
			<h1>👀USER ADMIN</h1>
		</header>
		<nav>
			<ul className='menu-list'>
				<li><Link to="/">홈</Link></li>
				<li><Link to="/search">검색</Link></li>
				<li><Link to="/add-userinfo">고객정보추가</Link></li>
			</ul>
		</nav>
		</>
	);
}