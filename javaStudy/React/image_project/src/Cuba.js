import cuba1 from "./img/cuba1.jpg";
import cuba2 from "./img/cuba2.jpg";
import cuba3 from "./img/cuba3.jpg";

export default function Cuba() {
  const cubaList = [
    { id: 1, src: cuba1, alt: "cuba1" },
    { id: 2, src: cuba2, alt: "cuba2" },
    { id: 3, src: cuba3, alt: "cuba3" },
  ];

  return (
    <>
      <ul className="img-list">
        {cubaList.map(img => (
          <li>
            <img key={img.id} src={img.src} alt={img.alt}></img>
          </li>
        ))}
      </ul>
    </>
  );
}
