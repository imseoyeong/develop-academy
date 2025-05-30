import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function DisplayUserInfo(){
    const userInfoList=useSelector(state=>state.userInfo.userInfoList);
    const list=userInfoList.map(t=> (
        <li key={t.userId}>
            <p><span>고객아이디</span>{t.userId}</p>
            <p><span>고객이름</span>{t.userName}</p>
            <p><span>전화번호</span>{t.mobile}</p>
            <p><span>출생년도</span>{t.birthYear}</p>
            <p><span>신장</span>{t.height}</p>
            <p><span>거주지역</span>{t.addr}</p>
            <p><span>가입일자</span>{t.joinDate}</p>
            <Link to={"/display-buyinfo/" + t.userId}>구매기록보기</Link>
        </li>
    ));

    return (
        <>
            <ul className={"userinfo-list"}>
                {list}
            </ul>
        </>
    );
}