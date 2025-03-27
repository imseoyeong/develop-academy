import { useState } from 'react';
import Header from './Header';
import Menu from './Menu';
import Write from './Write';
import List from './List';
import Read from './Read';

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
    
    const [readingId, setReadingId] = useState(0);
    const [nextId, setNextId] = useState(postList.length + 1);

    let content = null;
    switch(mode) {
        case "list":
            content = <List 
                postList={postList} 
                onChangeMode={(id) => {
                    setMode("read");
                    setReadingId(Number(id));
                }} 
            />; //postList를 List props로 넘겨줘야 함. 
            break;

        case "write":
            content = <Write 
                onSave={(_title, _body, _writer) => {
                    const post = {id: nextId, title: _title, body: _body, writer: _writer};
                    const newPostList = [...postList, post]; 
                    setPostList(newPostList);
                    setMode("list");
                    setNextId(nextId + 1);
                }} 
            />;
            break;

        case "read":
            const post = postList.find(post => Number(post.id) === readingId);
            
            content = <Read 
                post={post}
                onDelete = {() => {
                    const newPostList = postList.filter((p) => p.id !== post.id);
                    setPostList(newPostList);
                    setMode("list");
                }}
                onUpdate = {(title, body, writer) => {
                    const newPostList = {id: readingId, title, body, writer};
                    const postListArr = [...postList];

                    for (let i = 0; i < postListArr.length; i++) {
                        if (postListArr[i].id === readingId) {
                            postListArr[i] = newPostList;
                        }
                    }

                    setPostList(postListArr);
                    setMode("list");
                }}
            />
            break;
    }
    // //switch mode

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