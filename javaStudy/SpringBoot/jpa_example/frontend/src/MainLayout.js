import { Outlet } from 'react-router-dom';
import Header from './Header';

export default function MainLayout() {
	return (
		<>
		<div className='inner'>
			<Header/>
			<Outlet/>
		</div>
		</>
	);
}