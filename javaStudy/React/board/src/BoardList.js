import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function BoardList() {
    const boardList = useSelector((state) => state.boardList.boardItem);

    return (
        <section>
            <ul className={"board-list"}>
                {boardList.map((item) => (
                    <li>
                        <Link key={item.id}>
                            <p>{item.title}</p>
                            <p>{item.writer}</p>
                        </Link>
                    </li>
                ))}
            </ul>
        </section>
    );
}