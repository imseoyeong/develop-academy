import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function BoardList() {
    const boardList = useSelector((state) => state.boardList.boardItem);

    return (
        <section>
            <ul className={"board-list"}>
                {boardList.map((item) => (
                    <li key={item.postId}>
                        <Link to={`/list/${item.postId}`}>
                            <p>{item.postTitle}</p>
                            <p>{item.postUserName}</p>
                        </Link>
                    </li>
                ))}
            </ul>
        </section>
    );
}