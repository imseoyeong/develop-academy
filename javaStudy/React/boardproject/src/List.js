export default function List(props) {
    const postItem = [];
    
    for (let post of props.postList) {
        const item =
            <li key={post.id} >
                <a href='/' onClick={(e) => {
                    e.preventDefault();
                    props.onChangeMode(post.id); // 선택한 게시글의 id 저장

                }}>{post.title} (작성자: {post.writer})</a>
            </li>
        postItem.push(item);
    }

    return (
        <ul className='post-list'>
            {postItem}
        </ul>
    );
}