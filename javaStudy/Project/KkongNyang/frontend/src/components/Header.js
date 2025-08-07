import {Link, useNavigate} from "react-router-dom";

export default function Header() {
    const navigate = useNavigate();

    const handleBack = () => {
        navigate(-1);
    }

    return (
        <>
            <header>
                <div className={"header-wrap"}>
                    <h1>로고</h1>
                </div>
            </header>

            <header>
                <div className={"header-wrap"}>
                    <button onClick={handleBack}>뒤로가기</button>
                    <h1>page title</h1>
                </div>
            </header>
            <hr/>

        </>
    );
}