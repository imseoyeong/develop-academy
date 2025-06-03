import React from "react";
import apiClient from "../api/axiosInstance";
import {useDispatch} from "react-redux";
import {useNavigate} from "react-router-dom";
import {adminLogin, saveCsrfToken} from "../store";

export default function AdminLogin(){
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleAdminLogin= async (e)=>{
        e.preventDefault();
        const data = {username:"ADMIN_"+e.target.adminName.value ,password:e.target.password.value }
        try {
            const response = await apiClient.post("/login",new URLSearchParams(data));
            dispatch(saveCsrfToken(response.data['login-csrf-token']));
            dispatch(adminLogin());
            navigate("/");
        } catch (error) {
            if(error.response && error.response.data.error || error.response.status===404 || error.response.status===405){
                alert(error.response.data.error);
            }
            console.log(error);
        }
    }
    return (
        <>
            <form onSubmit={handleAdminLogin}>
                <p>관리자 아이디 : <input
                    type="text"
                    placeholder="Admin Name"
                    name="adminName"
                    required
                />
                </p>
                <p>관리자 비밀번호 : <input
                    type="password"
                    placeholder="Password"
                    name="password"
                    required
                />
                </p>
                <button type="submit">관리자 로그인</button>
            </form>
        </>
    );
}
