import {Outlet} from "react-router-dom";

export default function MainLayout() {
    return (
        <>
            <section>
                <Outlet/>
            </section>
        </>
    );
}