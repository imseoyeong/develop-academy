// #1
// -------------------------------------------------------------------

import Header from './Header';
import Nav from './Nav';
import Article from './Article';
import Create from './Create';
import Update from './Update';
import { useState } from 'react';


function App() {
    const [mode, setMode] = useState("WELCOME");
    const [id, setId] = useState(0);
    const [topics, setTopics] = useState([
        { id: 1, title: "html", body: "html is ..." },
        { id: 2, title: "css", body: "css is ..." },
        { id: 3, title: "javascript", body: "javascript is ..." },
    ]); 
    const [nextId, setNextId] = useState(topics.length + 1);

    let content = null;
    let contextControl = null;
    if (mode === "WELCOME") {
        content = <Article title="Welcome" body="Hello, WEB"></Article>;
    } else if (mode === "READ") {
        let title, body;
        for (let topic of topics) {
            if (topic.id === Number(id)) {
                title = topic.title;
                body = topic.body;
                break;
            }
        }
        content = <Article title={title} body={body}></Article>;
        contextControl = 
        <>
            <li><a href={"/update/" + id} onClick={(e) => {
                e.preventDefault();
                setMode("UPDATE");
            }}>Update</a></li>
            <li><button onClick={(e) => {
                const filterTopoics = topics.filter((t) => t.id !== Number(id)); //topics 배열에서 아이디가 현재 아이디와 다른 객체들만 골라내서 새 배열을 만들어서 리턴해준다.
                setTopics(filterTopoics);
                setMode("WELCOME");
            }}>Delete</button></li>
        </>
    } else if (mode === "CREATE") {
        content = <Create onCreate={(_title, _body) => {
            let newTopic = {id: nextId, title: _title, body: _body};
            let newTopics = [...topics, newTopic]; //...topics : 나머지 연산자 (레스트 연산자)
            // for (let t of topics) { //이 두 개의 코드를 간단하게 한 것이 위의 코드
            //     newTopic.push(t);
            // }
            // newTopics.push(newTopic);
            setTopics(newTopics);
            setId(newTopic.id);
            setNextId(nextId + 1);
            setMode("READ");
        }}></Create>
    } else if (mode === "UPDATE") {
        let topic = topics.find((t) => t.id === Number(id));
        for (let t of topics) {
            if (t.id === Number(id)) {
                topic = t;
                break;
            }
        }
        content = <Update title={topic.title} body={topic.body} onUpdate={(title, body) => {
            const updateTopic = {id: Number(id), title, body}; // {id: id, title: title, body: body} 동일. Update()에서 넘겨받은 title, body이다.
            const updateTopics = [...topics];
            for (let i = 0; i < updateTopics.length; i++) {
                if (updateTopics[i].id === Number(id)) {
                    updateTopics[i] = updateTopic;
                    break;
                }
            }
            setTopics(updateTopics);
            setMode("READ");
            //setTopics, setMode은 예약만 한거고 함수가 끝난 후 실행된다. 
        }}></Update>
    }

    return (
        <>
            <Header title="REACT" onChangeMode={() => {
                setMode("WELCOME");
            }}></Header>

            <Nav topics={topics} onChangeMode={(_id) => {
                setId(_id);
                setMode("READ");
            }}></Nav>

            {content}

            <li>
                <a href="/create" onClick={(e) => {
                    e.preventDefault();
                    setMode("CREATE");
                }}>Create</a>
            </li>

            {contextControl}
        </>
    );
}

export default App;

// -------------------------------------------------------------------
// [noti]
// - Nav를 계속 눌렀을 때 setMode("READ")를 다시 호출하지는 않음. 상태가 변했을 때만 호출 함.





// #2
// -------------------------------------------------------------------

// function App() {
//     function handleClick() {
//         alert("버튼을 클릭했습니다!");
//     }

//     return <button onClick={handleClick}>클릭하세요!</button>;
// }

// export default App;

// -------------------------------------------------------------------





// #3
// -------------------------------------------------------------------

// import ControlPanel from './ControlPanel';

// function App() {
//     return <ControlPanel />;
// }

// export default App;

// -------------------------------------------------------------------





// #4
// -------------------------------------------------------------------

// import Counter from './Counter';

// function App() {
//     // return <Counter />;
//     return (
//         <>
//             <Counter />;
//             <Counter />;
//             <Counter />;
//         </>
//     )
// }

// export default App;

// -------------------------------------------------------------------