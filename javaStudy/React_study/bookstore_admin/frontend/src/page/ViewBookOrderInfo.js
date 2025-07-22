import {useSelector} from "react-redux";
import {Link} from "react-router-dom";

export default function ViewBookOrderInfo() {
    const bookInfo = useSelector(state => state.madangInfo.bookInfo);

    return (
        <>
            <section>
                <h2>[ {bookInfo.bookName} ]의 주문기록</h2>

                {bookInfo.orders ? bookInfo.orders.map(t =>
                        <div>
                            <p>주문번호 : {t.orderId} </p>
                            <p>주문자 이름 : {t.custName} </p>
                            <p>판매가격 : {t.salePrice} </p>
                            <p>주문날짜 : {t.orderDate} </p>
                            <hr/>
                        </div>
                    )
                    :
                    <h3>주문기록이 없습니다.</h3>
                }

                <Link to={"/orderinfo/bookinfo/" + bookInfo.bookId}>뒤로</Link>
            </section>
        </>
    );
}