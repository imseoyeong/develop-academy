import apiClient from "../api/axiosInstance";

export default function ConnectCouple() {

    const handleCode = async (e) => {
        e.preventDefault();

        try {
            const response = await apiClient.post("/generate-code");
        } catch (error) {
            console.log(error);
        }
    }
//뭔가 잘못됨. 커플 코드 생성.... 도 해야하고 입력도 해야하고...


    return (
        <section id={"connect"}>
            <h2>서로를 연결해볼까요? </h2>

            <p>연결 코드를 입력해주세요.</p>
            <input type={"text"} name={"coupleCode"}/>
            <button type={"button"}>연결하기</button>

            <div>
                <p>아직 코드가 없어요?</p>
                <button type={"button"} onClick={handleCode}>[내 코드 생성하기]</button>
                <p>"서로 같은 코드를 입력해야 연결돼요"</p>
            </div>

            <div>
                <p>내 연결코드</p>
                <p>codenumber</p>
                <button>복사</button>
            </div>

        </section>
    );
}