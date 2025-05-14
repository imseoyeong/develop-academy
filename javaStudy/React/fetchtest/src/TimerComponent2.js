import { useEffect, useState } from 'react';

export default function TimerComponent2() {
	const [count, setCount] = useState(0);
	useEffect(() => {
		const interval = setInterval(() => {
			console.log(`Count: ${count}`);
		}, 1000);

		return () => {
			clearInterval(interval);
			console.log('Cleanup function executed');
		};
	}, [count]);

	return (
		<div>
			<p>Count: {count}</p>
			<button onClick={() => setCount(count + 1)}>Increase Count</button>
		</div>
	);
}