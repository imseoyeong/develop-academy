import {Link} from "react-router-dom";

export default function JoinInfoResult() {
    return (
        <>
        <section>
            <h2>정상적으로 저장되었습니다.</h2>
            <Link to={"/add-userinfo/joininfo"}>⌨계속 입력</Link>
        </section>
        </>
    );
}