import Header from './Header';
import Nav from './Nav';
import Article from './Article';


function App() {
    const topics = [
        { id: 1, title: "html", body: "html is ..." },
        { id: 2, title: "css", body: "css is ..." },
        { id: 3, title: "javascrpit", body: "javascrpit is ..." },
    ];

    return (
        <>
            <Header title="REACT" onChangeMode={() => {alert("헤더 눌렀을 때 알럿창~");}}></Header>
            <Nav topics={topics} onChangeMode={(id) => {alert(id);}}></Nav>
            <Article title="Welcome" body="Hello, Web"></Article>
        </>
    );
}

export default App;