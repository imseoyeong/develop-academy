import { useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux';
import { onUpdate, onDelete } from './postListSlice';

export default function Read() {
    const {postId} = useParams();
    const item = useSelector((state) => state.postList.postList.find((p) => p.id === Number(postId)));
    const dispatch = useDispatch();
    const navigate = useNavigate();
    
    const [title, setTitle] = useState(item? item.title:"");
    const [body, setBody] = useState(item? item.body:"");
    const [writer, setWriter] = useState(item? item.writer:"");

    if(!item){
        return;
    }

    return (
        <form className='write-form' onSubmit={(e) => e.preventDefault()}>
            <input type='text' name='title' placeholder='제목을 입력하세요' value={title} onChange={(e) => {
                setTitle(e.target.value)
            }}></input>

            <textarea name='body' rows={20} cols={40} placeholder='내용을 입력하세요' value={body} onChange={(e) => {
                setBody(e.target.value)
            }}></textarea>
            
            <input name='writer' type='text' placeholder='작성자를 입력하세요' value={writer} onChange={(e) => {
                setWriter(e.target.value)
            }}></input>

            <div className='btn-wrap'>
                <button className='btn' type='button' onClick={() => {
                    dispatch(onUpdate({ id: item.id, title, body, writer }));
                    navigate("/");
                }}>수정</button>
                <button className='btn btn-bdr' type='button' onClick={() => {
                    dispatch(onDelete({ id: item.id }));
                    navigate("/");
                }}>삭제</button>
            </div>
        </form>
    );
}