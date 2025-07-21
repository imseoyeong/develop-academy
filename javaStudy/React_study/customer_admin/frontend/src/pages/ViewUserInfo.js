import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function ViewUserInfo() {
    const userInfoList = useSelector((state) => state.userInfo.userInfoList);

    return (
        <>
            <section>
                <ul>
                    {userInfoList.map(t => (
                    <li key={t.userId}>
                        <p>고객아이디: {t.userId}</p>
                        <p>고객이름: {t.userName}</p>
                        <p>출생년도: {t.birthYear}</p>
                        <p>거주지역: {t.addr}</p>
                        <p>전화번호: {t.mobile}</p>
                        <p>신장: {t.height}</p>
                        <p>가입일자: {t.joinDate}</p>
                        <Link to={"/view-buyinfo/" + t.userId}>구매기록 보기</Link>
                        <hr/>
                    </li>
                    ))}
                </ul>
            </section>
        </>
    );
}