import canada1 from "./img/canada1.jpg";
import canada2 from "./img/canada2.jpg";
import canada3 from "./img/canada3.jpg";

export default function Canada() {
  const canadaList = [
    { id: 1, src: canada1, alt: "canada1" },
    { id: 2, src: canada2, alt: "canada2" },
    { id: 3, src: canada3, alt: "canada3" },
  ];

  return (
    <>
      <ul className="img-list">
        {canadaList.map(img => (
          <li>
            <img key={img.id} src={img.src} alt={img.alt}></img>
          </li>
        ))}
      </ul>
    </>
  );
}
