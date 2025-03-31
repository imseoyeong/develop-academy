import { useState } from "react";
import { useOutletContext, useParams } from "react-router-dom";

export default function ReadPost(){
    const {postList, onUpdate, onDelete} = useOutletContext();
    const {postId} = useParams();   
    const item = postList.find((p)=>p.id === Number(postId));
    
    const [title, setTitle] = useState(item? item.title:"");
    const [body, setBody] = useState(item? item.body:"");
    const [writer, setWriter] = useState(item? item.writer:"");

    if(!item){
        return;
    }

    return (
        <>
        <form onSubmit={(e)=>e.preventDefault()}>
            <p><input type="text" name="title" value={title} onChange={(e)=>{
                setTitle(e.target.value);
            }}></input></p>
            <p><textarea name="body" value={body} rows="20" cols="40" onChange={(e)=>{
                setBody(e.target.value);
            }}></textarea></p>
            <p><input type="text" name="writer" value={writer} onChange={(e)=>{
                setWriter(e.target.value);
            }}></input></p>
            <button onClick={(e)=>{
                onUpdate(item.id, title, body, writer);
            }}>수정</button>
            <button onClick={(e)=>{
                onDelete(item.id);
            }}>삭제</button>

        </form>
        </>
    );
}