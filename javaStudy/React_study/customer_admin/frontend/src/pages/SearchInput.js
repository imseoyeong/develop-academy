import {useNavigate, useOutletContext} from "react-router-dom";
import {useDispatch} from "react-redux";
import {addUserInfo, clearUserInfo} from "../store";
import apiClient from "../api/axiosInstance";
import errorDisplay from "../errorDisplay";

export default function SearchInput() {
    const {addr, birthyear} = useOutletContext();
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleSearch = async (e) => {
        e.preventDefault();

        let paramsData = {};
        let urlPath = null;

        if (addr) {
            paramsData = {addr: e.target.addr.value};
            urlPath = "addr";
        }
        if (birthyear) {
            paramsData = {...paramsData, birthyear: e.target.birthyear.value};
            urlPath = urlPath ? urlPath + "birthyear" : "birthyear";
        }

        try {
            await dispatch(clearUserInfo);
            const response = await apiClient.get("/userinfo/" + urlPath,
                {
                    params: paramsData,
                }
            );

            response.data.map((user) => {
                dispatch(addUserInfo(user));
            });

            navigate("/view-userinfo");
        } catch (error) {
            errorDisplay(error);
        }
    }

    return (
        <>
            <form onSubmit={handleSearch}>
                <ul>
                    {addr && (
                    <li>
                        <label htmlFor={"addr"}>지역</label>
                        <input type={"text"} name={"addr"} id={"addr"}/>
                    </li>
                    )}

                    {birthyear && (
                    <li>
                        <label htmlFor={"birthyear"}>출생년도</label>
                        <input type={"text"} name={"birthyear"} id={"birthyear"}/>
                    </li>
                    )}
                </ul>
                <button type={"submit"}>검색</button>
            </form>
        </>
    );
}