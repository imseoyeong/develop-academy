import {Link} from "react-router-dom";

export default function ViewOrderInfo_Nodata() {
    return (
        <>
            <h2>검색 데이터가 존재하지 않습니다.</h2>
            <Link to={"/orderinfo"}>이전으로</Link>
        </>
    );
}