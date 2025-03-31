import { useState } from 'react';
import { Outlet, Link, useParams, useNavigate, Route } from 'react-router-dom';

export default function MainLayout() {
    const [postList, setPostList] = useState([
        { id: 1, title: "반갑습니다", body: "Hello", writer: "임서영" },
        { id: 2, title: "안녕하세요", body: "Hello", writer: "임서영" },
    ]);

    const { postid } = useParams();
    const [nextId, setNextId] = useState(postList.length + 1);
    const post = postList.find(post => Number(post.id) === Number(postid));
    const navigate = useNavigate();

    // const onSave = (title, body, writer) => {
    //     const newPost = {id: postList.length + 1, title, body, writer};
    //     setPostList([...postList, newPost]); 
    //     navigate('/');
    // }

    const onSave = (title, body, writer) => {
        const post = {id: nextId, title, body, writer};
        postList.push(post);
        const newPostList = [...postList];
        setPostList(newPostList); 
        setNextId(nextId + 1);
        navigate('/');
    }

    // end onSave

    const onUpdate = (title, body, writer) => {
        const updatePost = {id: Number(postid), title, body, writer};

        const updatePostList = postList.map((post) => {
            if (post.id === Number(postid)) {
                return updatePost;
            } else {
                return post;
            }
        })

        setPostList(updatePostList);
        navigate('/');
    }
    // end onUpdate

    const onDelete = () => {
        const deletePostList = postList.filter((post) => post.id !== Number(postid));
         
        setPostList(deletePostList);
        navigate('/');
    }
    // end onDelete

    return (
        <>
            <h1>글 목록</h1>

            <ul className='menu-list'>
                <li><Link to='/write'>글쓰기</Link></li>
                <li><Link to='/'>목록으로</Link></li>
            </ul>

            <Outlet context={{ postList, postid, post, navigate, onSave, onUpdate, onDelete }} />
        </>
    );
}