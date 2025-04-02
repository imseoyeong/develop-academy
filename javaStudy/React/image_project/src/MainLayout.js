import { Link, Outlet } from 'react-router-dom';

export default function MainLayout() {
    return (
        <>
        <h2><Link to='/'>아프리카 갤러리</Link></h2>
        <Outlet/>
        </>
    );
}