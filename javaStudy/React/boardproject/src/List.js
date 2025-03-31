import { useOutletContext, Link } from 'react-router-dom';

export default function List() {
    const { postList } = useOutletContext();

    return (
        <ul className='post-list'>
            {postList.map((post) => (
            <li key={post.id}><Link to={"/list/" + post.id}>{post.title} (작성자: {post.writer})</Link></li>
        ))}
        </ul>
    );
}