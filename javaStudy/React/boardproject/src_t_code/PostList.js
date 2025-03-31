import { Link, useOutletContext } from "react-router-dom";

export default function PostList(){
    const {postList} = useOutletContext();
    const list=[];

    for(let post of postList){
        const item = <div key={post.id}><Link to={"/post/"+post.id}>{post.title}(작성자:{post.writer})</Link><hr/></div>;
        list.push(item);    
    }
    return (
        <>
        {list}
        </>
    );
}