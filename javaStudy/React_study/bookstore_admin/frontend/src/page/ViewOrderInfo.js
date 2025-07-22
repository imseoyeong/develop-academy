import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function ViewOrderInfo() {
    const orderList = useSelector(state => state.madangInfo.orderList);

    return (
        <>
            <section>
                <h2>검색 결과</h2>

                <ul>
                    {(orderList.length !== 0) && orderList.map(t =>
                    <li key={t.orderId}>
                        <p>주문번호 : {t.orderId}</p>
                        <p>고객아이디 : {t.custId}</p>
                        <p>서적아이디 : <Link to={"/orderinfo/bookinfo/" + t.bookId}>{t.bookId}</Link></p>
                        <p>주문가격 : {t.salePrice}</p>
                        <p>주문일자 : {t.orderDate}</p>
                        <hr/>
                    </li>
                    )}
                </ul>
            </section>
        </>
    );
}