export default function Signup() {
    return (
        <section id={"signup"}>
            <form>
                <ul>
                    <li>
                        <label>프로필 이미지</label>
                        <input type={"file"}/>
                    </li>
                    <li>
                        <div>
                            <label>아이디</label>
                            <input type={"text"}/>
                        </div>
                       <button type={"button"}>중복확인</button>
                    </li>
                    <li>
                        <label>비밀번호</label>
                        <input type={"password"}/>
                    </li>
                    <li>
                        <label>비밀번호 확인</label>
                        <input type={"password"}/>
                    </li>
                    <li>
                        <label>이름</label>
                        <input type={"text"}/>
                    </li>
                    <li>
                        <label>생년월일</label>
                        <input type={"date"}/>
                    </li>
                    <li>
                        <label>성별</label>
                        <div>
                            <label form={"male"}>남성</label>
                            <input type={"radio"} id={"male"} name={"gender"} value={"male"}/>
                            <label form={"male"}>여성</label>
                            <input type={"radio"} id={"female"} name={"gender"} value={"female"}/>
                        </div>
                    </li>
                </ul>

                <button>회원가입</button>
            </form>
        </section>
    );
}