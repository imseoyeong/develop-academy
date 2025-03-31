import { useOutletContext } from 'react-router-dom';

export default function GrandchildComponent() {
    const { sharedData } = useOutletContext();

    return (
        <div>
            <h3>Grandchild Component</h3>
            <p>Data from Parent: { sharedData }</p>
        </div>
    );
}