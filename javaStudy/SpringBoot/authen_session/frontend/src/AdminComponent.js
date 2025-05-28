import {useState} from "react";
import apiClient from "./api/apiinstance";
import axios from "axios";

export default function AdminComponent() {
    const [message, setMessage] = useState(null);

    const handleAdmin = async (e) => {
        try {
            const response = await apiClient.get("/admin", {
                withCredentials: true
            });
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
        try {
            const response = await axios.post("http://localhost:8080/logout", {},
                {
                    withCredentials: true,
                }
            );
            setMessage(response.data);
        } catch (error) {
            console.log(error);
        }
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