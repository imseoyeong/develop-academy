import {useOutletContext} from "react-router-dom";
import apiClient from "../api/axiosInstance";
import {useDispatch} from "react-redux";
import {addUserInfo, clearUserInfo, setUserInfoList} from "../store";
import {useNavigate} from "react-router-dom";
import errorDisplay from "../util/errorDisplay";

export default function DetailCondition() {
    const {addr, birthyear} = useOutletContext();
    const addrObj = (<li><label htmlFor='addr'>지역</label> <input type="text" name="addr"></input></li>);
    const birthYearObj = (<li><label htmlFor='birthyear'>출생년도</label> <input type="text" name="birthyear"></input></li>);
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        let paramsData = null;
        let urlpath = null;
        if (addr) {
            paramsData = {addr: e.target.addr.value};
            urlpath = "addr";
        }
        if (birthyear) {
            paramsData = {...paramsData, birthyear: e.target.birthyear.value};
            urlpath = urlpath ? urlpath + "birthyear" : "birthyear";
        }
        try {
            await dispatch(clearUserInfo());
            const response = await apiClient.get("/userinfo/" + urlpath, {
                params: paramsData,
            });
            response.data.map(t => dispatch(addUserInfo(t)));
            // dispatch(setUserInfoList(response.data));
            navigate("/display-userinfo");

        } catch (error) {
            errorDisplay(error);
        }
    }
    return (
        <>
            <p>
                <form onSubmit={handleSubmit}>
                    <ul className='detail-input-list'>
                        {addr && addrObj}
                        {birthyear && birthYearObj}
                        <button type="submit">검색하기</button>
                    </ul>
                </form>
            </p>
        </>
    );
}