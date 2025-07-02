import {useNavigate, useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {removeItem, updateItem} from "./boardListSlice";
import {useEffect, useState} from "react";
import axios from "axios";

export default function BoardView() {
    const {itemId} = useParams();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const boardItem = useSelector((state) => state.boardList.boardItem.find((item) => item.postId === Number(itemId)));

    const [postTitle, setPostTitle] = useState(boardItem? boardItem.postTitle : "");
    const [postContent, setPostContent] = useState(boardItem? boardItem.postContent : "");

    // boardItem이 준비되고 나서 title과 content를 읽게한다.
    // useEffect(() => {
    //     if (boardItem) {
    //         setPostTitle(boardItem.postTitle);
    //         setPostContent(boardItem.postContent);
    //     }
    // }, [boardItem]); // boardItem이 바뀔 때마다 실행.

    const handleUpdate = async () => {
        try {
            const response = await axios.put("http://localhost:8080/post", {
                postId: Number(itemId),
                postTitle,
                postContent,
                postUserName: boardItem.postUserName,
            });

            dispatch(updateItem(response.data));
            navigate("/list");
        } catch (err) {
            console.log(err);
        }
    };

    const handleRemove = async () => {
        try {
            await axios.delete(`http://localhost:8080/post/${itemId}`);

            dispatch(removeItem(Number(itemId)));
            navigate("/list");
        } catch (err) {
            console.log(err);
        }
    };

    if(!boardItem) {
        return null;
    }

    return (
        <form className={"write-form inner"}>
            <input name={"postTitle"} value={postTitle} placeholder={"제목을 입력해주세요"} onChange={(e)=> setPostTitle(e.target.value)}/>
            <textarea name={"postContent"} value={postContent} rows={"10"} placeholder={"내용을 입력해주세요"} onChange={(e)=> setPostContent(e.target.value)}></textarea>
            <p>작성자 : {boardItem.postUserName}</p>

            <div className={"btn-wrap"}>
                <button type={"button"} onClick={handleUpdate}>수정</button>
                <button type={"button"} onClick={handleRemove}>삭제</button>
            </div>
        </form>
    );
}