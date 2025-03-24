function Header(props) { // { title: "REACT", onChangeMode: () => {alert("Header");} }
    return (
        <header>
            <h1><a href='/' onClick={(e) => {
                e.preventDefault(); //기본 기능 제거
                props.onChangeMode();
            }}>{props.title}</a></h1>
        </header>
    );
}

export default Header;