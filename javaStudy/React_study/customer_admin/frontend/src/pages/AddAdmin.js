import {useNavigate} from "react-router-dom";
import apiClient from "../api/axiosInstance";

export default function AddAdmin() {
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const data = {authenNumber: e.target.authenNumber.value, username: e.target.adminname.value, password: e.target.password.value};

        try {
            const response = await apiClient.post("/admin-join", data);
            navigate("/");
        } catch (error) {
            if (error.response && error.response.status === 450 || error.response.status === 460) {
                alert(error.response.data);
            }

            e.target.reset();
            console.log(error);
        }
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <div>
                    <span>인증번호 : </span>
                    <input type={"text"} name={"authenNumber"} required/>
                </div>
                <div>
                    <span>관리자 아이디 : </span>
                    <input type={"text"} name={"adminname"} required/>
                </div>
                <div>
                    <span>관리자 비밀번호 : </span>
                    <input type={"password"} name={"password"} required/>
                </div>

                <button type={"submit"}>추가</button>
            </form>
        </>
    );
}