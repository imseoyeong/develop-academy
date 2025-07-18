import {useRef, useState} from "react";
import errorDisplay from "../errorDisplay";
import apiClient from "../api/axiosInstance";
import {useNavigate} from "react-router-dom";

export default function BuyInfo() {
    const [selectId, setSelectId] = useState(false);
    const useridRef = useRef();
    const navigate = useNavigate();

    const handleSelect = async () => {
        try {
            if (useridRef.current.value.length === 0) {
                alert("아이디를 입력해주세요.");
                return;
            }

            const response = await apiClient.get("/userinfo/check-id/" + useridRef.current.value);
            if (response.status === 250) {
                useridRef.current.disabled = true;
                setSelectId(true);
            } else {
                alert("없는 아이디입니다.");
                useridRef.current.value = "";
            }
        } catch (error) {
            errorDisplay(error);
        }
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const formData = new FormData(e.target);
            const data = Object.fromEntries(formData.entries());

            data.userId = useridRef.current.value;

            const response = await apiClient.post("/buyinfo", data);
            navigate("/add-userinfo/buyinfo-result");
        } catch (error) {
            errorDisplay(error);
        }
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <div>
                    <span>고객아이디 : </span>
                    <input type={"text"} name={"userId"} ref={useridRef} required/>
                    <button type={"button"} onClick={handleSelect}>아이디 선택</button>
                </div>
                {selectId && (
                    <>
                        <div>
                            <span>제품이름 : </span>
                            <input type={"text"} name={"prodName"} required/>
                        </div>
                        <div>
                            <span>그룹이름 : </span>
                            <input type={"text"} name={"groupName"}/>
                        </div>
                        <div>
                            <span>가격 : </span>
                            <input type={"text"} name={"price"} required/>
                        </div>
                        <div>
                            <span>구매개수 : </span>
                            <input type={"text"} name={"amount"} required/>
                        </div>

                        <button type={"submit"}>입력완료</button>
                    </>
                )}
            </form>
        </>
    );
}