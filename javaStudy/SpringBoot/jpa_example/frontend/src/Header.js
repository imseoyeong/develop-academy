import { Link } from 'react-router-dom';

export default function Header() {
	return (
		<>
		<header>
			<h1>고객관리</h1>
		</header>
		<nav>
			<ul className='menu-list'>
				<li><Link to="/">홈</Link></li>
				<li><Link to="/search">검색</Link></li>
			</ul>
		</nav>
		</>
	);
}