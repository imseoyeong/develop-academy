import { useEffect } from 'react';

export default function TimerComponent() {
	useEffect(() => {
		const timer = setInterval(() => {
			console.log('Timer tick');
		}, 1000);

		return () => {
			clearInterval(timer);
			console.log('Timer stopped');
		};
	}, []);

	return (
		<div>Timer is running</div>
	);
}