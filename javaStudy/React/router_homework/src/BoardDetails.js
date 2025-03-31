import { useNavigate, useParams } from 'react-router-dom';
import { useOutletContext } from 'react-router-dom';

export default function BoardDetails() {
    const { contentList } = useOutletContext();
    const { postid } = useParams();
    const navigate = useNavigate();

    const post = contentList.find((p) => p.id === Number(postid));
    const nextPost = (e) => {
        const nextId = Number(postid) + 1;
        if (nextId > contentList.length) {
            alert("다음 게시글이 없습니다.");
        } else {
            navigate("/post/" + nextId);
        }
    }

    return (
        <>
        <h3>게시글 상세</h3>
        <p><strong>글 ID: </strong>{postid}</p>
        {/* <p>{contentList[Number(postid - 1)].body}</p> */}
        <p>{post.body}</p>
        <button onClick={nextPost}>다음 게시글▶</button>
        </>
    );
}