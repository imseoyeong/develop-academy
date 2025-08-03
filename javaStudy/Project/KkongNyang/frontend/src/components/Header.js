import {Link} from "react-router-dom";

export default function Header() {
    return (
        <>
            <header>
                <div className={"header-wrap"}>
                    <h1>로고</h1>
                </div>
            </header>

            <header>
                <div className={"header-wrap"}>
                    <Link to={"#"}>뒤로가기</Link>
                    <h1>page title</h1>
                </div>
            </header>
        </>
    );
}