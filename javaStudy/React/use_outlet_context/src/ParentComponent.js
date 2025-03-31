import { Outlet } from 'react-router-dom';

export default function ParentComponent() {
    const sharedData = "This data is shared with all nested routes";

    return (
        <div>
            <h1>Parent Component</h1>
            <Outlet context={{ sharedData }} />
        </div>
    );
}
