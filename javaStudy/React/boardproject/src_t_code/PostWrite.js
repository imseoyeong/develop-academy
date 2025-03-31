import { useOutletContext } from "react-router-dom";

export default function PostWrite(){
    const {onSave} = useOutletContext();
    return(
        <>
        <form onSubmit={(e)=>{
            e.preventDefault();
            const title =e.target.title.value;
            const body = e.target.body.value;
            const writer = e.target.writer.value;
            onSave(title, body, writer);
        }}>
            <p><input type="text" name="title" placeholder="제목입력"></input></p>
            <p><textarea name="body" placeholder="내용입력" rows="20" cols="40"></textarea></p>
            <p><input type="text" name="writer" placeholder="작성자이름"></input></p>
            <input type="submit" value="저장"></input>
        </form>
        </>
    );
}