export default function CoupleProfile() {
    return (
        <section>
            <form>
                <ul>
                    <li>
                        <label>만난 날짜</label>
                        <input type={"date"}/>
                    </li>
                    <li>
                        <label>내 닉네임</label>
                        <input type={"text"}/>
                    </li>
                </ul>

                <button>저장</button>
            </form>
        </section>
    );
}