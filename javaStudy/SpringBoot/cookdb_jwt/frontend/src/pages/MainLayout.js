import {NavLink,Link, Outlet, useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {adminLogout, saveCsrfToken} from "../store";
import axios from "axios";
import InitMenu from "./InitMenu";
import MainMenu from "./MainMenu";

export default function MainLayout(){
    const navigate = useNavigate();
    const adminLoginFlag=useSelector(state=>state.userInfo.adminLoginFlag);
    const userLoginFlag =useSelector(state=>state.userInfo.userLoginFlag);
    const issuanceToken = useSelector(state=>state.userInfo.issuanceToken);
    const dispatch = useDispatch();

    useEffect(()=>{
        const fetchData=async ()=>{
            try{
                const response=await axios.get('http://localhost:8080/csrf-token', { withCredentials: true });
                await dispatch(saveCsrfToken(response.data["csrf-token"]));
                console.log("토큰생성 성공: ", response.data["csrf-token"]);
            }catch(error){
                console.log(error);
                console.log("csrf토큰 발급에러");
            }
        }
        fetchData();
    },[issuanceToken]);

    return (
        <>
            <h1>&lt;고객 관리&gt;</h1>
            {!(adminLoginFlag || userLoginFlag)? <InitMenu/> : <MainMenu/>}

            <Outlet/>
        </>
    );
}