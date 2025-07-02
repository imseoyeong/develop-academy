import {useDispatch} from "react-redux";
import {addItem} from "./boardListSlice";
import {useNavigate} from "react-router-dom";
import axios from "axios";

export default function BoardWrite() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const postTitle = e.target.postTitle.value;
        const postContent = e.target.postContent.value;
        const postUserName = e.target.postUserName.value;

        try {
            const response = await axios.post("http://localhost:8080/post", {
                postTitle,
                postContent,
                postUserName,
            });

            dispatch(addItem(response.data));
            navigate("/list");
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <form className={"write-form inner"} onSubmit={handleSubmit}>
            <input name={"postTitle"} placeholder={"제목을 입력해주세요"}/>
            <textarea name={"postContent"} rows={"10"} placeholder={"내용을 입력해주세요"}></textarea>
            <input name={"postUserName"} placeholder={"작성자를 입력해주세요"}/>

            <button type={"submit"}>저장</button>
        </form>
    );
}