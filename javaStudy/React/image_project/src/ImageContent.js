import { Link, Outlet, useParams } from "react-router-dom";
import { useSelector } from 'react-redux';

export default function ImageContent() {
    const { imgid } = useParams();
    const content = useSelector((state) => state.ShowImage.imageList.find((p) => p.id === Number(imgid)));


    return (
    <>
    <h3>{content.desc}</h3>
    <ul className="img-list">
    {content.map(img => (
        <li>
        <img key={img.id} src={img.src + img.id} alt={img.alt}></img>
        </li>
    ))}
    </ul>
    </>
    );
}
