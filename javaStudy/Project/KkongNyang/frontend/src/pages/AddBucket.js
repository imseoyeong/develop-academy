import {useDispatch, useSelector} from "react-redux";
import apiClient from "../api/axiosInstance";
import {addBucket} from "../store/bucketSlice";

export default function AddBucket() {
    const dispatch = useDispatch();
    const coupleInfo = useSelector((state) => state.userInfo.coupleInfo);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const todoValue = e.target.todo.value;

        try {
            const response = await apiClient.post(`/bucketlist/${coupleInfo?.coupleCode}`, todoValue, {
                headers: {
                    'Content-Type': 'text/plain',
                },
            });
            dispatch(addBucket(response.data));
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <div className={"bottom-sheet"}>
            <div className={"sheet-header"}>
                <button>닫기</button>
            </div>

            <form onSubmit={handleSubmit}>
                <div className={"content-wrap"}>
                    <input type={"text"} name={"todo"}/>
                </div>

                <div className={"btn-wrap"}>
                    <button type={"submit"}>저장</button>
                </div>
            </form>
        </div>
    );
}