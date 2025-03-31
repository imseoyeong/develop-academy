import { Link, Outlet } from 'react-router-dom';

export default function MainLayout() {
    const contentList = [
        { id: 1, title: "첫 번째 게시글", body: "첫 번째 게시글 내용입니다." },
        { id: 2, title: "두 번째 게시글", body: "두 번째 게시글 내용입니다." },
        { id: 3, title: "세 번째 게시글", body: "세 번째 게시글 내용입니다." },
    ];

    return (
        <>
        <h2>게시판 앱</h2>
        <Link to='/'>목록</Link>
        <hr></hr>
        <Outlet context={{ contentList }} />
        </>
    );
}