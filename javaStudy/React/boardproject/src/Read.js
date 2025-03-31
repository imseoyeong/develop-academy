import { useState } from 'react';
import { useOutletContext } from 'react-router-dom';

export default function Read() {
    const { post, onUpdate, onDelete } = useOutletContext();

    const [title, setTitle] = useState(post.title);
    const [body, setBody] = useState(post.body);
    const [writer, setWriter] = useState(post.writer);

    return (
        <form className='write-form'>
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
                    onUpdate(title, body, writer);
                }}>수정</button>
                <button className='btn btn-bdr' type='button' onClick={() => {
                    onDelete();
                }}>삭제</button>
            </div>
        </form>
    );
}