import { useState } from 'react';
import Header from './Header';
import Menu from './Menu';
import Write from './Write';
import List from './List';

import "./Style.css";


function App() {
    const [ mode, setMode ] = useState("list");
    const menuList = [
        { id: 1, title: "글쓰기", mode: "write" },
        { id: 2, title: "목록으로", mode: "list" },
    ];

    const [postList, setPostList] = useState([
        { id: 1, title: "반갑습니다", body: "Hello", writer: "임서영" },
        { id: 2, title: "안녕하세요", body: "Hello", writer: "임서영" },
    ]);
    // const postList = [
    //     { id:1, title: "반갑습니다", body: "Hello", writer: "임서영" },
    // ]; //얘를 왜 state로 바꿔야 하는걸까요?
    
    
    let content = null;
    switch(mode) {
        case "list":
            content = <List postList={postList} />; //postList를 List props로 넘겨줘야 함. 
            break;
        case "write":
            content = <Write />;
            break;    
        case "read":
            break;
    }

    return (
        <>
            <Header title="글 목록"></Header>

            <Menu menuList={menuList} onSelect={(_mode) => {
                setMode(_mode);
            }}></Menu>

            {content}
        </>
    );
}

export default App;