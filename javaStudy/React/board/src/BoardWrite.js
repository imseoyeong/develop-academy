import {useDispatch} from "react-redux";
import {addItem} from "./boardListSlice";
import {useNavigate} from "react-router-dom";

export default function BoardWrite() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        const title = e.target.title.value;
        const content = e.target.content.value;
        const writer = e.target.writer.value;

        dispatch(addItem({title, content, writer}));
        navigate("/list");
    }

    return (
        <form className={"write-form inner"} onSubmit={handleSubmit}>
            <input name={"title"} placeholder={"제목을 입력해주세요"}/>
            <textarea name={"content"} rows={"10"} placeholder={"내용을 입력해주세요"}></textarea>
            <input name={"writer"} placeholder={"작성자를 입력해주세요"}/>

            <button type={"submit"}>저장</button>
        </form>
    );
}