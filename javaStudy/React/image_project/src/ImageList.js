export default function ImageList() {
    const imageList = [
        { id: 1, src: "/img/africa.jpg", desc: "아프리카" },
        { id: 2, src: "./img/brazil.jpg", desc: "브라질" },
        { id: 3, src: "./img/canada.jpg", desc: "캐나다" },
        { id: 4, src: "./img/cuba.jpg", desc: "쿠바" },
    ];

    return (
        <>
            <ul className='img-list'>
                {imageList.map((img) => <li><img src={img.src} id={img.id}></img></li>)}
            </ul>
        </>
    );
}