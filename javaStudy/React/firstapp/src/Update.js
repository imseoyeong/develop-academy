import { useState } from 'react';

export default function Update(props) {
    const [title, setTitle] = useState(props.title);
    const [body, setBody] = useState(props.body);

    return (
        <article>
            <h2>Update</h2>
            <form onSubmit={(e) => {
                e.preventDefault();
                // const title = e.target.title.value; //e.target은 form
                // const body = e.target.body.value;
                props.onUpdate(title, body);
            }}>
                <p><input type="text" name="title" value={title} onChange={(e) => {
                    setTitle(e.target.value);
                }}></input></p>
                <p><textarea name="body" value={body} onChange={(e) => {
                    setBody(e.target.value);
                }}></textarea></p>
                <p><input type="submit" value="Update"></input></p>
            </form>
        </article>
    );
}

// -------------------------------------------------------------------
// [noti]
// - value 값을 설정하지 않았을 때는 상관없지만 설정을 했을 경우 엘리먼트들은 제어 컨트롤 엘리먼트가 된다.
// - 입력된 내용에 대해서 직접 컨트롤을 해야한다.
// - props.title: read only라고 뜸. 왜냐? 부모로부터 전달받은 데이터는 기본적으로 불변 객체이다. 받아만 쓸 수 있고 여기서 고칠 수가 없다. 