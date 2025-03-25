import { useState } from 'react';

function Counter() {
    const [state, setState] = useState(0); //state라는 변수를 만들고 초기값을 0으로 설정. setState 라는 함수로 이 값을 변경 가능

    return (
        <div>
            <h1>State 값 : {state}</h1>
            {/* setState() 함수를 사용하여 state의 값을 1씩 증가시킴 */}
            <button onClick={() => setState(state + 1)}>1씩 증가</button>
        </div>
    )
}

export default Counter;