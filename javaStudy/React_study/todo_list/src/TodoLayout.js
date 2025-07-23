import {Link, Outlet} from "react-router-dom";

export default function TodoLayout() {
    return (
        <>
            <header>
                <h1>TODO LIST</h1>
                <nav>
                    <Link to={"/todo"}>TODO 목록</Link>
                    <Link to={"/todo/add-todo"}>ADD TODO</Link>
                </nav>
            </header>

            <Outlet/>
        </>
    );
}