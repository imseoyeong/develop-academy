import {Link} from "react-router-dom";

export default function StartScreen() {
    return (
        <section id={"start-page"}>
            <Link to={"/login"}>시작하기</Link>
        </section>
    );
}