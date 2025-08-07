import {useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import app from "../App";
import apiClient from "../api/axiosInstance";
import {setCoupleInfo} from "../store/userSlice";

export default function CoupleProfile() {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const coupleInfo = useSelector((state) => state.userInfo.coupleInfo);
    const coupleCode = coupleInfo?.coupleCode;

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        formData.append("coupleCode", coupleCode);

        try {
            const response = await apiClient.post("/couple/update-profile", formData, {
                headers: {
                    "Content-Type": "multipart/form-data",
                },
            });
            dispatch(setCoupleInfo(response.data));
            navigate("/home");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <section>
            <form onSubmit={handleSubmit}>
                <ul>
                    <li>
                        <label>만난 날짜</label>
                        <input type={"date"} name={"firstday"} required/>
                    </li>
                    <li>
                        <label>내 닉네임</label>
                        <input type={"text"} name={"part1Nickname"} required/>
                    </li>
                    <li>
                        <label>배경 이미지</label>
                        <input type={"file"} name={"coupleProfileImageFile"}/>
                    </li>
                </ul>

                <button type={"submit"}>저장</button>
            </form>
        </section>
    );
}