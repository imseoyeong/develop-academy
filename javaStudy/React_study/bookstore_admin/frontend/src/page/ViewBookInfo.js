import {Link, useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import apiClient from "../api/apiinstance";
import {setBookInfo} from "../store";

export default function ViewBookInfo() {
    const {bookid} = useParams();
    const bookInfo = useSelector(state => state.madangInfo.bookInfo);
    const dispatch = useDispatch();

    useEffect(() => {
        const fetchData = async () => {
            try {
                await dispatch(setBookInfo(null));

                const response = await apiClient.get("/bookinfo/" + bookid);
                dispatch(setBookInfo(response.data));
            } catch (error) {
                console.log(error);
            }
        }

        fetchData();
    }, []);

    return (
        <>
            <section>
                <h2>서적 정보</h2>

                {bookInfo &&
                <div>
                    <p>서적아이디 : {bookInfo.bookId}</p>
                    <p>서적이름 : {bookInfo.bookName}</p>
                    <p>출판사 : {bookInfo.publisher}</p>
                    <p>정가 : {bookInfo.price}</p>
                    <Link to={"/orderinfo/book-order-info"}>주문기록 보러가기</Link>
                    <hr/>
                </div>
                }

                <Link to={"/orderinfo/data"}>뒤로</Link>
            </section>
        </>
    );
}