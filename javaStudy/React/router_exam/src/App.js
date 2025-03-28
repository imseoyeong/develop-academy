import logo from './logo.svg';
import './App.css';
import { Link, Outlet, Route, Routes, useNavigate, useParams } from 'react-router-dom';


function Home() {
    return (
        <>
        <h2>Home</h2>
        Home is ...
        </>
    );
}

const contents = [
    { id: 1, title: "Html", body: "Html is ..." },
    { id: 2, title: "Css", body: "Css is ..." },
    { id: 3, title: "JavaScript", body: "JavaScript is ..." },
];

function Topic() {
    const { topicid } = useParams(); //{topicid: "3"}
    const topic = contents.find((t) => t.id === Number(topicid));

    return (
        <>
        <h3>{topic.body}</h3>
        </>
    );
}

function Topics() {
    const list = [];
    for (let t of contents) {
        list.push(<li><Link to={"/topics/" + t.id}>{t.title}</Link></li>);
    }

    return (
        <>
        <h2>Topics</h2>
        <ul>
            {list}
        </ul>
        <Outlet/>
        </>
    );
}

function Contact() {
    return (
        <>
        <h2>Contact</h2>
        Contact is ...
        </>
    );
}

function MaunLayout() {
    const navigate = useNavigate(); // 네비게이트 함수를 리턴해주는 함수?....콜백함수

    return (
        <>
        <h1>Hello React Router</h1>
        <ul>
            <li><Link to='/home'>Home</Link></li>
            <li><Link to='/topics'>Topics</Link></li>
            <li><Link to='/contact'>Contact</Link></li>
        </ul>
        <Outlet/><br/>
        <button onClick={(e) => {
            navigate("/");
        }}>홈으로</button>
        </>
    );
}

function Welcome() {
    return (
        <>
        <h2>Welcome!!!</h2>
        </>
    );
}


function App() {
  return (
    <>
    <Routes>
        <Route path='/' element={<MaunLayout/>}>
            <Route index element={<Welcome/>}></Route>
            <Route path='/home' element={<Home/>}></Route>
            <Route path='/topics' element={<Topics/>}>
                <Route path='/topics/:topicid' element={<Topic/>}></Route>
            </Route>
            <Route path='/contact' element={<Contact/>}></Route>
        </Route>
    </Routes>
    </>
  );
}

// [noti]
// - Link를 눌렀을 때 밑에 뜨지 않고 페이지 이동? 하는 이유는 경로가 바뀌기 때문
// - 그래서 MaunLayout Route 자식으로 메뉴들을 넣는다. 하지만 그냥 넣는다고 출력이 되진 않고, MaunLayout 함수 안에 Outlet을 넣어서 자식 컴포넌트(메뉴들)를 넣을 자리를 알려준다. 
export default App;
