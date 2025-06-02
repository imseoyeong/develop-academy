import {useState} from "react";
import apiClient from "./api/apiinstance";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {setToken} from "./store";

export default function AdminComponent() {
    const [message, setMessage] = useState(null);
    const dispatch = useDispatch();
    const csrfToken = useSelector(state => state.token.token);

    const handleAdmin = async (e) => {
        try {
            const response = await apiClient.get("/admin");
            setMessage(response.data);
        } catch (error) {
            if (error.response && error.response.status === 403) {
                setMessage("관리자 계정만 접근 가능합니다.");
            } else if (error.response && error.response.status === 401) {
                setMessage(error.response.data.message);
            } else {
                console.log(error);
            }
        }
    }

    const handleLogout = async (e) => {
        dispatch(setToken(null));
        setMessage("로그아웃 되었습니다.");
    }

    return (
        <>
            <section>
                <div className={"btn-wrap"}>
                    <button onClick={handleLogout}>Logout</button>
                    <button onClick={handleAdmin}>Admin</button>
                </div>
                <br/>
                {message}
            </section>
        </>
    );
}