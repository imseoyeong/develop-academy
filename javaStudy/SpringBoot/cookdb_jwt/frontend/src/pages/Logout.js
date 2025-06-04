import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {useDispatch, useSelector} from "react-redux";
import {adminLogout, setIssuanceToken, setToken, userLogout} from "../store";
import {useNavigate} from "react-router-dom";

export default function Logout(){
    const adminLoginFlag=useSelector(state=>state.userInfo.adminLoginFlag);
    const userLoginFlag =useSelector(state=>state.userInfo.userLoginFlag);
    const dispatch = useDispatch();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchData = async ()=>{
            try{
                const response = await apiClient.delete("/refresh-cookie", {}, {
                    withCredentials: true,
                });
                if(adminLoginFlag){
                    await dispatch(adminLogout());
                }
                if(userLoginFlag){
                    await  dispatch(userLogout());
                }

                dispatch(setToken(null));
                await dispatch(setIssuanceToken(Date.now()));
                navigate("/");
                console.log(response.data);
            }catch(error){
                console.log(error);
            }
        };
        fetchData();
    }, []);
    return (
        <>
        </>
    );
}