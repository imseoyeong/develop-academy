export default function Write(props) {
    return (
        <form className='write-form' onSubmit={(e) => {
            e.preventDefault();
            const title = e.target.title.value;
            const body = e.target.body.value;
            const writer = e.target.writer.value;
            props.onSave(title, body, writer)
        }}>
            <input type='text' name='title' placeholder='제목을 입력하세요'></input>
            <textarea name='body' rows={20} cols={40} placeholder='내용을 입력하세요'></textarea>
            <input name='writer' type='text' placeholder='작성자를 입력하세요'></input>

            <div className='btn-wrap'>
                <button type='submit' className='btn'>저장</button>
            </div>
        </form>
    );
}