import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {useDispatch} from "react-redux";
import {setCoupleInfo, setUserInfo} from "../store/userSlice";

export default function CheckCoupleStatus() {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    useEffect(() => {
        const checkCoupleStatus = async () => {
            try {
                const myInfoRes = await apiClient.get("/my-info");
                const myInfo = myInfoRes.data;
                const coupleCode = myInfo.coupleCode;
                dispatch(setUserInfo(myInfo));

                if (!coupleCode) {
                    navigate("/connect");
                } else {
                    const coupleRes = await apiClient.get(`/couple/${coupleCode}`);
                    const coupleProfile = coupleRes.data;
                    dispatch(setCoupleInfo(coupleProfile));

                    if (!coupleProfile.firstday || !coupleProfile.part1Nickname) {
                        navigate("/couple-profile");
                    } else {
                        navigate("/home");
                    }
                }
            } catch (error) {
                console.log(error);
            }
        }

        checkCoupleStatus();
    }, [navigate]);

    return null;
}