import { useEffect } from 'react';

export default function ExampleComponent() {
	useEffect(() => {
		console.log('Component mounted');

		return () => {
			console.log('Component unmount');
		};
	}, []);

	return (
		<div>Example Component</div>
	);
}