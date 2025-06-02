import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {logout, setToken} from "../store";
import {useEffect} from "react";

export default function Logout() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const csrfToken = useSelector(state => state.userInfo.token);

    useEffect(() => {
        const handleLogout = async () => {
            if (!csrfToken) {
                // console.warn("CSRF 토큰 없음");
                dispatch(logout());
                dispatch(setToken(null));
                navigate("/");
                return;
            }

            try {
                await axios.post("http://localhost:8080/logout", {},
                    {
                        headers: {
                            "X-CSRF-TOKEN": csrfToken
                        },
                        withCredentials: true
                });
                dispatch(logout());
                dispatch(setToken(null));

                const response = await axios.get("http://localhost:8080/csrf-token", {
                    withCredentials: true
                });
                dispatch(setToken(response.data["csrf-token"]));
                navigate("/");
            } catch (error) {
                console.log(error);
            }
        };
        handleLogout();
    }, [dispatch, csrfToken, navigate]);

    return (
        <>
        </>
    );
}