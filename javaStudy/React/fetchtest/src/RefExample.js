import { useRef } from 'react';

export default function RefExample() {
	const myRef = useRef(0);

	const handleClick = () => {
		console.log('Before:', myRef.current);
		myRef.current += 1;
		console.log('After:', myRef.current);
	};

	return (
		<>
		<button onClick={handleClick}>Increase Ref</button>
		</>
	);
}