import { Link, Outlet } from "react-router-dom";
import { useSelector } from 'react-redux';

export default function MainLayout() {
    const imageList = useSelector((state) => state.ShowImage.imageList);

    return (
    <>
        <h2>
        <Link to="/">국가 갤러리</Link>
        </h2>
        <ul className="img-list">
            {imageList.map(img => (
                <li>
                <Link to={img.link}>
                    <img key={img.id} src={img.src} alt={img.desc}></img>
                </Link>
                </li>
            ))}
        </ul>
        <Outlet />
    </>
    );
}
