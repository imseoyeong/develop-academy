import { useState } from 'react';

export default function Read(props) {
    //불변성 유지 컨트롤을 위해 state 생성
    const [title, setTitle] = useState(props.post.title);
    const [body, setBody] = useState(props.post.body);
    const [writer, setWriter] = useState(props.post.writer);

    return (
        <form className='write-form'>
            <input type='text' name='title' placeholder='제목을 입력하세요' value={title} onChange={(e) => {
                setTitle(e.target.value);
            }}></input>

            <textarea name='body' rows={20} cols={40} placeholder='내용을 입력하세요' value={body} onChange={(e) => {
                setBody(e.target.value);
            }}></textarea>
            
            <input name='writer' type='text' placeholder='작성자를 입력하세요' value={writer} onChange={(e) => {
                setWriter(e.target.value);
            }}></input>
            
            <div className='btn-wrap'>
                <button className='btn' type='button' onClick={() => {
                    props.onUpdate(title, body, writer);
                }}>수정</button>
                <button className='btn btn-bdr' type='button' onClick={() => {
                    props.onDelete();
                }}>삭제</button>
            </div>
        </form>
    );
}