import { Outlet, useNavigate } from "react-router-dom";
import { useState } from "react";
import Header from "./Header";
import Menu from "./Menu";
export default function MainLayout(){ 
  const menuList=[
    {id:1, title:"글쓰기", path:"/write"},
    {id:2, title:"목록으로", path:"/"},
  ];
  const [postList, setPostList]=useState([
    {id:1, title:"반갑습니다.", body:"Hello", writer:"김진아"},
    { id: 2, title: "안녕하세요", body: "안녕하세요", writer:"김진아"},
  ]);

  const [nextId, setNextId] = useState(postList.length + 1);
  const navigate = useNavigate();

  const onSave=(title, body, writer)=>{
    const post = {id:nextId, title, body, writer}; //{id:3, title:"hi", body:"...", writer:"김진아"}
    postList.push(post);
    const newPostList =[...postList];
    setPostList(newPostList);   
    setNextId(nextId+1);
    navigate("/");
  };

  const onUpdate=(id, title, body, writer)=>{
    const updatePost = {id, title, body, writer};
    for(let i=0; i<postList.length; i++){
      if(postList[i].id === Number(id)){
        postList[i] = updatePost;
        break;
      }
    }
    const newPostList = [...postList];
    setPostList(newPostList);
    navigate("/");      
  };

  const onDelete=(id)=>{
    const newPostList=postList.filter((post)=>post.id !== Number(id));
    setPostList(newPostList);
    navigate("/");
  };     

  return (
    <>
    <Header title="글목록"></Header>    
    <Menu menuList={menuList}></Menu>
    <Outlet context={{postList, onSave, onUpdate, onDelete}}/>
    </>
    
  );
}