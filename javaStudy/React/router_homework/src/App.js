import logo from './logo.svg';
import './App.css';
import { Link, Outlet, Route, Routes, useNavigate, useParams } from 'react-router-dom';


const contentList = [
    { id: 1, title: "첫 번째 게시글", body: "첫 번째 게시글 내용입니다." },
    { id: 2, title: "두 번째 게시글", body: "두 번째 게시글 내용입니다." },
    { id: 3, title: "세 번째 게시글", body: "세 번째 게시글 내용입니다." },
];

function BoardDetails() {
    const { postid } = useParams();
    const boardDetails = contentList.find((t) => t.id === Number(postid));
    const navigate = useNavigate();

    return (
        <>
        <h3>게시글 상세</h3>
        <p><strong>글 ID: </strong>{boardDetails.id}</p>
        <p>{boardDetails.body}</p>
        <button onClick={(e) => {
            if (boardDetails.id >= contentList.length) {
                alert("다음 게시글이 없습니다.")
            } else {
                navigate("/post/" + (boardDetails.id + 1));
            }
        }}>다음 게시글▶</button>
        </>
    );
}

function BoardList() {
    const list = [];
    for (let t of contentList) {
        list.push(<li key={t.id}><Link to={"/post/" + t.id}>{t.title}</Link></li>);
    }

    return (
        <>
        <h3>게시글 목록</h3>
        <ul>
            {list}
        </ul>
        </>
    );
}

function MainLayout() {
    return (
        <>
        <h2>게시판 앱</h2>
        <Link to='/'>목록</Link>
        <hr></hr>
        <Outlet/>
        </>
    );
}

function App() {
  return (
    <>
    <Routes>
        <Route path='/' element={<MainLayout/>}>
            <Route index element={<BoardList/>}></Route>
            <Route path='/post/:postid' element={<BoardDetails/>}></Route>
        </Route>
    </Routes>
    </>
  );
}

export default App;