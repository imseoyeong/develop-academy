import {Link} from "react-router-dom";
import AddBucket from "./AddBucket";
import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import apiClient from "../api/axiosInstance";
import {setBucketList} from "../store/bucketSlice";

export default function BucketList() {
    const dispatch = useDispatch();
    const bucketList = useSelector(state => state.bucket.bucketList);
    const coupleInfo = useSelector(state => state.userInfo.coupleInfo);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await apiClient.get(`/bucketlist/${coupleInfo.coupleCode}`);
                dispatch(setBucketList(response.data));
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, [dispatch]);

    return (
        <section id={"bucket"}>
            <button type={"button"}>추가</button>
            <ul>
                {bucketList.map((t) => (
                <li key={t.id}>
                    {t.todo}
                </li>
                ))}
            </ul>

            <AddBucket/>
        </section>
    );
}