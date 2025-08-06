import apiClient from "../api/axiosInstance";
import {useEffect, useRef, useState} from "react";
import {useDispatch} from "react-redux";
import {coupleInfo} from "../store/userSlice";
import {useNavigate} from "react-router-dom";

export default function ConnectCouple() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const codeRef = useRef();
    const [myCode, setMyCode] = useState("");
    const [show, setShow] = useState(false);

    const handleCode = async () => {
        try {
            const response = await apiClient.post("/couple/generate-code");
            setMyCode(response.data.coupleCode);
            setShow(true);
        } catch (error) {
            console.log(error);
        }
    }

    const handleCopy = () => {
        if (myCode) {
            navigator.clipboard.writeText(myCode);
            alert("복사 완료!")
        }
    }

    const handlematch = async () => {
        try {
            const response = await apiClient.post("/couple/match", {
                coupleCode: codeRef.current.value,
            });
            dispatch(coupleInfo(response.data));
            navigate("/couple-profile");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <section id={"connect"}>
            <h2>서로를 연결해볼까요? </h2>

            <p>연결 코드를 입력해주세요.</p>
            <input type={"text"} name={"coupleCode"} ref={codeRef}/>
            <button type={"button"} onClick={handlematch}>연결하기</button>

            <div>
                <p>아직 코드가 없어요?</p>
                <button type={"button"} onClick={handleCode}>[내 코드 생성하기]</button>
                <p>"서로 같은 코드를 입력해야 연결돼요"</p>
            </div>

            {show && (
            <div>
                <p>내 연결코드</p>
                <p>{myCode}</p>
                <button onClick={handleCopy}>복사</button>
            </div>
            )}
        </section>
    );
}