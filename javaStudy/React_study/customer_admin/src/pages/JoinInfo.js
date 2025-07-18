import {useRef, useState} from "react";
import apiClient from "../api/axiosInstance";
import errorDisplay from "../errorDisplay";
import {useNavigate} from "react-router-dom";

export default function JoinInfo() {
    const [check, setCheck] = useState(false);
    const useridRef = useRef();
    const navigate = useNavigate();

    const handleCheck = async () => {
        try {
            const checkUrl = "/userinfo/check-id/" + useridRef.current.value;
            const response = await apiClient.get(checkUrl);

            if (response.status === 250) {
                alert("이미 사용중인 아이디입니다.");
            } else {
                alert(response.data);
                setCheck(true);
            }
        } catch (error) {
            errorDisplay(error);
        }
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if (!check) {
                alert("중복체크를 하고 오세요");
                return;
            }

            const formData = new FormData(e.target);
            const data = Object.fromEntries(formData.entries());
            if (!data.mobile) {
                data.mobile = null;
            }


            const response = await apiClient.post("/userinfo/join-userinfo", data);
            navigate("/add-userinfo/joininfo-result");
        } catch (error) {
            if(error.response && error.response.data && error.response.data["joinDate"]){
                alert(error.response.data["joinDate"]);
            }
            errorDisplay(error);
        }
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <div>
                    <span>고객아이디 : </span>
                    <input type={"text"} name={"userId"} ref={useridRef} required/>
                    <button type={"button"} onClick={handleCheck}>중복체크</button>
                </div>
                <div>
                    <span>고객이름 : </span>
                    <input type={"text"} name={"userName"} required/>
                </div>
                <div>
                    <span>전화번호 : </span>
                    <input type={"text"} name={"mobile"}/>
                </div>
                <div>
                    <span>출생년도 : </span>
                    <input type={"text"} name={"birthYear"} required/>
                </div>
                <div>
                    <span>신장 : </span>
                    <input type={"text"} name={"height"} required/>
                </div>
                <div>
                    <span>거주지역 : </span>
                    <input type={"text"} name={"addr"} required/>
                </div>
                <div>
                    <span>가입일자 : </span>
                    <input type={"date"} name={"joinDate"} required/>
                </div>

                <button type={"submit"}>저장</button>
            </form>
        </>
    );
}