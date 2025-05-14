import { useEffect, useState } from 'react';

export default function IncreaseCount() {
	const [count, setCount] = useState(0);

	useEffect(() => {
		console.log(`Count value updated to: ${count}`);
	}, [count]);

	return (
		<div>
			<p>{count}</p>
			<button onClick={() => setCount(count + 1)}>Increase Count</button>
		</div>
	);
}