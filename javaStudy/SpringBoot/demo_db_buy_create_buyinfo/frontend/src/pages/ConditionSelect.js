import {Outlet} from "react-router-dom";
import {useState, useRef} from "react";
import {useNavigate} from "react-router-dom";

export default function ConditionSelect() {
    const [context, setContext] = useState(null);
    const flag = useRef(false);
    const navigate = useNavigate();
    const handleSubmit = (e) => {
        e.preventDefault();
        flag.current = false;
        // setContext(null);
        let newContext = null;
        if (e.target.check[0].checked) {
            newContext = {addr: "addr"};
            flag.current = true;
        }
        if (e.target.check[1].checked) {
            newContext = {...newContext, birthyear: "birthyear"};
            flag.current = true;
        }
        setContext(newContext);
        navigate("/search/detail-condition");
    }
    return (
        <>
            <form onSubmit={handleSubmit}>
                <h2>고객 검색</h2>

                <div className='select-wrap'>
                    <ul className='select-list'>
                        <li>
                            <input id="addr" type="checkbox" name="check"/>
                            <label htmlFor="addr">지역</label>
                        </li>
                        <li>
                            <input id="birthyear" type="checkbox" name="check"/>
                            <label htmlFor="birthyear">출생년도</label>
                        </li>
                    </ul>
                    <button type="submit">조건선택</button>
                </div>
            </form>
            {flag.current && <Outlet context={context}/>}
        </>
    );
}