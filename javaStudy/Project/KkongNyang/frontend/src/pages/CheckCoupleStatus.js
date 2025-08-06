import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";

export default function CheckCoupleStatus() {
    const navigate = useNavigate();

    useEffect(() => {
        const checkCoupleStatus = async () => {
            try {
                const myInfoRes = await apiClient.get("/my-info");
                const myInfo = myInfoRes.data;
                const coupleCode = myInfo.coupleCode;

                if (!coupleCode) {
                    navigate("/connect");
                } else {
                    const coupleRes = await apiClient.get(`/couple/${coupleCode}`);
                    const coupleProfile = coupleRes.data;

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