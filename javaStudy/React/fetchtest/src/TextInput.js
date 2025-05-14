import { useRef } from 'react';

export default function TextInput() {
	const inputEl = useRef(null);
	const focusInput = () => {
		inputEl.current.style.backgroundColor="orange";
	};

	return (
		<>
		<div>
			{/* <input ref={inputEl} type='text' /> */}
			<div ref={inputEl}>하이미디어</div>
			<button onClick={focusInput}>Focus the input</button>
		</div>
		</>
	);
}