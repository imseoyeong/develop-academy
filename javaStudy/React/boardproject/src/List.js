export default function List(props) {
    const postItem = [];
    
    for (let i of props.postList) {
        const item =
            <li key={i.id} >
                <a href='/'>{i.title} (작성자: {i.writer})</a>
            </li>
        postItem.push(item);
    }

    return (
        <ul className='post-list'>
            {postItem}
        </ul>
    );
}