import { Link } from 'react-router-dom';
import { useOutletContext } from 'react-router-dom';

export default function BoardList() {
    const { contentList } = useOutletContext();

    // const list = [];
    // for (let t of contentList) {
    //     list.push(<li key={t.id}><Link to={"/post/" + t.id}>{t.title}</Link></li>);
    // }

    return (
        <>
        <h3>게시글 목록</h3>
        <ul>
            {/* {list} */}
            {contentList.map((post) => (
                <li key={post.id}><Link to={"/post/" + post.id}>{post.title}</Link></li>
            ))}
        </ul>
        </>
    );
}