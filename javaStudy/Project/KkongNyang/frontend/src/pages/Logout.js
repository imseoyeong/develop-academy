import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {setToken} from "../store/tokenSlice";
import {logout} from "../store/userSlice";

export default function Logout() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const userLoginFlag = useSelector(state => state.userInfo.userLoginFlag);

    useEffect(() => {
        const logoutData = async () => {
            try {
                const response = await apiClient.delete("/logout");
                dispatch(setToken(null));

                if (userLoginFlag) {
                    dispatch(logout());
                }

                navigate("/");
            } catch (error) {
                console.log(error);
            }
        }

        logoutData();
    }, []);

    return null;
}