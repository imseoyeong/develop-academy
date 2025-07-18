import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {logout, setToken} from "../store";

export default function Logout() {
    const adminLoginFlag = useSelector(state => state.userInfo.adminLoginFlag);
    const userLoginFlag = useSelector(state => state.userInfo.userLoginFlag);
    const dispatch = useDispatch();
    const navigate = useNavigate();

    useEffect(() => {
        const logoutData = async () => {
            try {
                const response = await apiClient.delete("/refresh-cookie");
                dispatch(setToken(null));

                if (adminLoginFlag || userLoginFlag) {
                    dispatch(logout());
                }

                navigate("/");
            } catch (error) {
                console.log(error);
            }
        };

        logoutData();
    }, []);

    return (
        <>
        </>
    );
}