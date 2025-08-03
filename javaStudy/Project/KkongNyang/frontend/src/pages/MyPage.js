import {Link} from "react-router-dom";

export default function MyPage() {
    return (
        <section id={"mypage"}>
            <Link to={"#"}>
                커플 프로필 섹션
            </Link>
            <ul>
                <li><Link to={"#"}>내 정보</Link></li>
                <li><Link to={"#"}>커플연결</Link></li>
                <li><Link to={"#"}>로그아웃</Link></li>
                <li><Link to={"#"}>테마</Link></li>
            </ul>
        </section>
    );
}