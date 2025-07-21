import {Link, useParams} from "react-router-dom";
import {useSelector} from "react-redux";
import {useEffect, useState} from "react";
import apiClient from "../api/axiosInstance";
import errorDisplay from "../errorDisplay";

export default function ViewBuyInfo() {
    const {userId} = useParams();
    const user = useSelector(state => state.userInfo.userInfoList.find(t => t.userId === userId));
    const [buyInfo, setBuyInfo] = useState([]);
    const [buyFlag, setBuyFlag] = useState(true);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await apiClient.get("/buyinfo/" + userId);

                if (response.status === 250) {
                    setBuyFlag(false);
                } else {
                    setBuyInfo(response.data);
                }
            } catch (error) {
                errorDisplay(error);
            }
        }
        fetchData();
    }, [userId]);

    return (
        <>
            <section>
                {buyFlag ? (
                    buyInfo.map(t => (
                        <div key={user.userId}>
                            <p>번호: {t.num} 고객이름: {user.userId} 구입상품: {t.prodName} 가격: {t.price} 개수: {t.amount}</p>
                            <hr/>
                        </div>
                    ))
                ) : (
                    <p>구매 이력이 없습니다.</p>
                )}

                <Link to={"/view-userinfo"}>고객정보 다시보기</Link>
            </section>
        </>
    );
}