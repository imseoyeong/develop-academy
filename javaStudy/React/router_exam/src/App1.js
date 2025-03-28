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
    { id: 3, title: "JavaScrript", body: "JavaScrript is ..." },
];

function Topic() {
    const { topicid } = useParams();
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
        list.push(<li key={t.id}><Link to={"/topics/" + t.id}>{t.title}</Link></li>)
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

function Welcome() {
    return (
        <>
        <h2>Welcome!!!</h2>
        </>
    );
}

function MainLayout() {
    const navigate = useNavigate();

    return (
        <>
        <h1>Hello React Router</h1>
        <ul>
            <li><Link to="/home">Home</Link></li>
            <li><Link to="/topics">Topics</Link></li>
            <li><Link to="/contact">Contact</Link></li>
        </ul>
        <Outlet/><br></br>
        <button onClick={(e) => {
            navigate("/");
        }}>홈으로</button>
        </>
    );
}


function App1() {
  return (
    <>
    <Routes>
        <Route path='/' element={<MainLayout/>}>
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

export default App1;
