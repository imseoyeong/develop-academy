import {Outlet, useNavigate} from "react-router-dom";
import {useDispatch} from "react-redux";
import apiClient from "./api/apiinstance";


export default function OrderInfoLayout() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        let path = null;

        if (e.target.elements["before"].checked) {
            path = "before";
        } else if (e.target.elements["after"].checked) {
            path = "after";
        }

        if (path === null) {
            alert("이전/이후를 선택해주세요");
        } else {
            try {
                const response = await apiClient.get("/orderinfo" + path, {
                    params: {
                        date: e.target.date.value
                    }
                });

                if (response.status === 250) {

                }
            } catch (error) {
                console.log(error);
            }
        }
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <input id={"before"} type={"radio"} name={"date"}/>
                <label>이전</label>

                <input id={"after"} type={"radio"} name={"date"}/>
                <label>이후</label>

                <button type={"submit"}>조건선택</button>
            </form>

            <Outlet/>
        </>
    );
}