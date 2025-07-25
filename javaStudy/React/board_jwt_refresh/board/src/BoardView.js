import {useNavigate, useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {removeItem, updateItem} from "./boardListSlice";
import {useEffect, useRef, useState} from "react";
import axios from "axios";

export default function BoardView() {
    const {itemId} = useParams();
    const commentRef = useRef();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const boardItem = useSelector((state) => state.boardList.boardItem.find((item) => item.postId === Number(itemId)));
    const currentUser = useSelector((state) => state.userList.currentUser);
    const token = useSelector((state) => state.userList.token);

    const [postTitle, setPostTitle] = useState(boardItem ? boardItem.postTitle : "");
    const [postContent, setPostContent] = useState(boardItem ? boardItem.postContent : "");

    const handleUpdate = async () => {
        try {
            const response = await axios.put("http://localhost:8080/post", {
                postId: Number(itemId),
                postTitle,
                postContent,
                postUserName: boardItem.postUserName,
            }, {
                headers: {
                    "Content-Type": "application/json",
                    "authorization": token,
                }
            });

            console.log("Token: ", token);
            dispatch(updateItem(response.data));
            navigate("/list");
        } catch (err) {
            console.log(err);
        }
    };

    const handleRemove = async () => {
        try {
            await axios.delete(`http://localhost:8080/post/${itemId}`, {
                headers: {
                    "Content-Type": "application/json",
                    "authorization": token,
                }
            });

            console.log("Token: ", token);
            dispatch(removeItem(Number(itemId)));
            navigate("/list");
        } catch (err) {
            console.log(err);
        }
    };

    if (!boardItem) {
        return null;
    }

    const handleComment = async () => {
        try {
            const response = await axios.post("/post/comment", {
                comment: commentRef.current,
            });

        } catch (error) {
            console.log(error);
        }
    }

    return (
        <form className={"write-form inner"}>
            <input name={"postTitle"} value={postTitle} placeholder={"제목을 입력해주세요"}
                   onChange={(e) => setPostTitle(e.target.value)}/>
            <textarea name={"postContent"} value={postContent} rows={"10"} placeholder={"내용을 입력해주세요"}
                      onChange={(e) => setPostContent(e.target.value)}></textarea>
            <p>작성자 : {boardItem.postUserName}</p>

            {/*TODO: 댓글 기능!!*/}
            <div>
                <h3>댓글</h3>

                <ul>
                    <li>
                        <p>홍길동</p>
                        <p>안녕하세요 반갑습니다~~~~</p>
                    </li>
                    <li>
                        <p>길순홍</p>
                        <p>어서오세요</p>
                    </li>
                </ul>

                <div>
                    <textarea name={"comment"} ref={commentRef} placeholder={"댓글을 입력해주세요"}></textarea>
                    <button className={"btn"} type={"button"} onClick={handleComment}>확인</button>
                </div>
            </div>

            {currentUser?.username === boardItem.postUserName && (
                <div className={"btn-wrap"}>
                    <button className={"btn"} type={"button"} onClick={handleUpdate}>수정</button>
                    <button className={"btn"} type={"button"} onClick={handleRemove}>삭제</button>
                </div>
            )}
        </form>
    );
}