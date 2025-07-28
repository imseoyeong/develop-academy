import {useNavigate, useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {addComment, removeComment, removeItem, updateItem} from "./boardListSlice";
import {useEffect, useRef, useState} from "react";
import axios from "axios";
import apiClient from "./api/axiosInstance";

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
            const response = await apiClient.put("/post", {
                postId: Number(itemId),
                postTitle,
                postContent,
                postUserName: boardItem.postUserName,
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
            await apiClient.delete(`/post/${itemId}`);

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
            const response = await apiClient.post("/post/comment", {
                postId: boardItem.postId,
                comment: commentRef.current.value,
                writerId: currentUser.username,
                writerName: currentUser.userFullName,
            });

            dispatch(addComment({postId: boardItem.postId, newComment: response.data}));
            commentRef.current.value = "";
        } catch (error) {
            console.log(error);
        }
    }

    const handleCommentRemove = async (commentId) => {
        try {
            await apiClient.delete(`/post/comment/${commentId}`);
            dispatch(removeComment({postId: boardItem.postId, commentId}));
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

            <div className={"comment-wrap"}>
                <h3>댓글</h3>
                <ul>
                    {boardItem.commentList.map((comment) =>
                    <li key={comment.id}>
                        <p>{comment.writerName}</p>
                        <p>{comment.comment}</p>

                        {currentUser?.username === comment.writerId && (
                            <div className={"btn-wrap"}>
                                {/*<button className={"btn"} type={"button"}>수정</button>*/}
                                <button className={"btn"} type={"button"} onClick={() => handleCommentRemove(comment.id)}>삭제</button>
                            </div>
                        )}
                    </li>
                    )}
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