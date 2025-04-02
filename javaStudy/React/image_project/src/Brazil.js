import brazil1 from "./img/brazil1.jpg";
import brazil2 from "./img/brazil2.jpg";
import brazil3 from "./img/brazil3.jpg";

export default function Brazil() {
  const brazilList = [
    { id: 1, src: brazil1, alt: "brazil1" },
    { id: 2, src: brazil2, alt: "brazil2" },
    { id: 3, src: brazil3, alt: "brazil3" },
  ];

  return (
    <>
      <ul className="img-list">
        {brazilList.map(img => (
          <li>
            <img key={img.id} src={img.src} alt={img.alt}></img>
          </li>
        ))}
      </ul>
    </>
  );
}
