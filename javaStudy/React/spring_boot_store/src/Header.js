import { Link } from 'react-router-dom';

export default function Header(props) {
    return (
        <>
		<header>
			<h1>TEST STORE</h1>
			<ul className='menu-list'>
				<li><Link to='/'>LIST</Link></li>
				<li><Link to='/newproduct'>NEW PRODUCT</Link></li>
			</ul>
		</header>
        </>
    );
}