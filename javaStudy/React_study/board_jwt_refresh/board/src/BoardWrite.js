import {useDispatch, useSelector} from "react-redux";
import {addItem} from "./boardListSlice";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import apiClient from "./api/axiosInstance";

export default function BoardWrite() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const currentUser = useSelector((state) => state.userList.currentUser);
    const token = useSelector((state) => state.userList.token);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const postTitle = e.target.postTitle.value;
        const postContent = e.target.postContent.value;

        try {
            const response = await apiClient.post("/post", {
                postTitle,
                postContent,
                postUserName: currentUser.username,
            });

            console.log("Token: ", token);
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

            <button className={"btn"} type={"submit"}>저장</button>
        </form>
    );
}