import {useNavigate} from "react-router-dom";
import {useDispatch} from "react-redux";
import {useRef} from "react";
import {addUser} from "../store/userSlice";
import axios from "axios";

export default function Signup() {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);

        try {
            const response = await axios.post("http://localhost:8080/api/join", formData);
            dispatch(addUser(response.data));
            alert("가입에 성공했습니다.");
            navigate("/login");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <section id={"signup"}>
            <form onSubmit={handleSubmit}>
                <ul>
                    <li>
                        <label>프로필 이미지</label>
                        <input type={"file"} name={"profileimg"}/>
                    </li>
                    <li>
                        <div>
                            <label>아이디</label>
                            <input type={"text"} ref={idRef} name={"username"} required/>
                        </div>
                       {/*<button type={"button"} onClick={handleCheck}>중복확인</button>*/}
                    </li>
                    <li>
                        <label>비밀번호</label>
                        <input type={"password"} name={"password"} required/>
                    </li>
                    <li>
                        <label>이름</label>
                        <input type={"text"} name={"realname"} required/>
                    </li>
                    <li>
                        <label>생년월일</label>
                        <input type={"date"} name={"birthday"} required/>
                    </li>
                    <li>
                        <label>성별</label>
                        <div>
                            <label htmlFor={"male"}>남성</label>
                            <input type={"radio"} id={"M"} name={"gender"} value={"M"}/>
                            <label htmlFor={"male"}>여성</label>
                            <input type={"radio"} id={"F"} name={"gender"} value={"F"}/>
                        </div>
                    </li>
                </ul>

                <button type={"submit"}>회원가입</button>
            </form>
        </section>
    );
}