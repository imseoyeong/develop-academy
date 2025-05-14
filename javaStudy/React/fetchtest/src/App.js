import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import TextInput from './TextInput';
import RefExample from './RefExample';
import DelayedMessage from './DelayedMessage';
import TimerCounter from './TimerCounter';
import IncreaseCount from './IncreaseCount';
import ExampleComponent from './ExampleComponent';
import TimerComponent from './TimerComponent';
import AutoFocusInput from './AutoFocusInput';
import CounterComponent from './CounterComponent';
import TimerComponent2 from './TimerComponent2';

// function App() {
// 	const [ flag, setFlag ] = useState(false);

// 	return (
// 		<>
// 		{/* 버튼이 눌릴 때 마다 flag 값이 바뀐다. */}
// 		<button onClick={(e) => setFlag(!flag)}>컴포넌트 변경</button>
// 		{flag && <TimerComponent2/>}
// 		{/* {flag && <CounterComponent/>} */}
// 		{/* {flag && <AutoFocusInput/>} */}
// 		{/* {flag && <TimerComponent/>} */}
// 		{/* {flag && <ExampleComponent/>} */}
// 		{/* {flag && <IncreaseCount/>} */}
// 		{/* {flag && <TimerCounter/>} */}
// 		{/* {flag && <DelayedMessage/>} */}

// 		{/* <TextInput/> */}
// 		{/* <RefExample/> */}
// 		</>
// 	);
// }


function App() {
	const [ content, setContent ] = useState(null);

	useEffect(() => {
		fetch("http://localhost:8080/userlist")
			.then(response => {
				if(!response.ok) {
					throw new Error("네트워크 오류");
				}
				return response.json();
			})
			.then(data => {
				setContent(data.map(t => <div key={t.userid}>{t.username}<br/></div>));
			})
			.catch(error => {
				console.log(error);
			});
	}, []);

	return (
		<>
		{content}
		</>
	);
}

export default App;
