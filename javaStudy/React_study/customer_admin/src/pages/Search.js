import {Outlet, useNavigate} from "react-router-dom";
import {useRef, useState} from "react";

export default function Search() {
    const [context, setContext] = useState(null);
    const navigator = useNavigate();
    const flag = useRef(false);

    const handleSubmit = (e) => {
        e.preventDefault();

        let newContext = {};

        if (e.target.elements["addr"].checked) {
            newContext = {addr: "addr"};
            flag.current = true;
        }
        if (e.target.elements["birthyear"].checked) {
            newContext = {...newContext, birthyear: "birthyear"};
            flag.current = true;
        }

        setContext(newContext);
        navigator("/search/search-input");
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <ul>
                    <li>
                        <input type={"checkbox"} name={"addr"} id={"addr"}/>
                        <label htmlFor={"addr"}>지역</label>
                    </li>
                    <li>
                        <input type={"checkbox"} name={"birthyear"} id={"birthyear"}/>
                        <label htmlFor={"birthyear"}>출생년도</label>
                    </li>
                </ul>
                <button type={"submit"}>조건선택</button>
            </form>

            {flag.current && <Outlet context={context}/>}
        </>
    );
}