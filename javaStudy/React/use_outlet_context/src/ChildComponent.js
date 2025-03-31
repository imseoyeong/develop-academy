import { Outlet, useOutletContext } from 'react-router-dom';

export default function ChildComponent() {
    const { sharedData } = useOutletContext();

    return (
        <div>
            <h2>Child Component</h2>
            <p>Data from Parent: { sharedData }</p>
            <Outlet context={{ sharedData }} />
        </div>
    );
}