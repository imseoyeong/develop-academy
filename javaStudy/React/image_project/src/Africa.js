import africa1 from "./img/africa1.jpg";
import africa2 from "./img/africa2.jpg";
import africa3 from "./img/africa3.jpg";

export default function Africa() {
  const africaList = [
    { id: 1, src: africa1, alt: "africa1" },
    { id: 2, src: africa2, alt: "africa2" },
    { id: 3, src: africa3, alt: "africa3" },
  ];

  return (
    <>
      <ul className="img-list">
        {africaList.map(img => (
          <li>
            <img key={img.id} src={img.src} alt={img.alt}></img>
          </li>
        ))}
      </ul>
    </>
  );
}
