import {Outlet, useNavigate} from "react-router-dom";
import {useDispatch} from "react-redux";
import apiClient from "../api/apiinstance";
import {setOrderList} from "../store";


export default function OrderInfoLayout() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        let path = null;

        if (e.target.dateRadio[0].checked) {
            path = "before";
        } else if (e.target.dateRadio[1].checked) {
            path = "after";
        }

        if (path === null) {
            alert("이전/이후를 선택해주세요");
        } else {
            try {
                const response = await apiClient.get("/orderinfo/" + path, {
                    params: {
                        date: e.target.date.value
                    }
                });

                if (response.status === 250) {
                    dispatch(setOrderList([]));
                    navigate("/orderinfo/nodata");
                } else {
                    dispatch(setOrderList(response.data));
                    navigate("/orderinfo/data");
                }
            } catch (error) {
                console.log(error);
            }
        }
    }

    return (
        <>
            <form onSubmit={handleSubmit} className={"search-radio-form"}>
                <ul>
                    <li>
                        <input id={"before"} type={"radio"} name={"dateRadio"}/>
                        <label htmlFor={"before"}>이전</label>
                    </li>
                    <li>
                        <input id={"after"} type={"radio"} name={"dateRadio"}/>
                        <label htmlFor={"after"}>이후</label>
                    </li>
                    <li>
                        <input id={"date"} type={"date"} name={"date"} required />
                    </li>
                    <li>
                        <button type={"submit"}>조건선택</button>
                    </li>
                </ul>
            </form>

            <Outlet/>
        </>
    );
}