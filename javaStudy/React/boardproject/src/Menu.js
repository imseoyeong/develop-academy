export default function Menu(props) {
    const menuArr = [];
    for (let m of props.menuList) {
        const item =
            <li key={m.id}>
                <a href='/' onClick={(e) => {
                    e.preventDefault();
                    props.onSelect(m.mode);
                }}>{m.title}</a>
            </li>;
        menuArr.push(item);
    }

    return (
        <ul className='menu-list'>
            {menuArr}
        </ul>
    );
}