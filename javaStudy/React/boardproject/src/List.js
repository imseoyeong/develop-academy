import { Link } from "react-router-dom";
import { useSelector } from 'react-redux';

export default function List() {
    const postList = useSelector((state) => state.postList.postList);

    const list=[];
    for(let post of postList){
        const item = <li key={post.id}><Link to={"/post/" + post.id}>{post.title} (작성자: {post.writer})</Link></li>;
        list.push(item);
    }

    return (
        <ul className='post-list'>
            {list}
        </ul>
    );
}