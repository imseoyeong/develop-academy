import { useEffect, useRef } from 'react';

export default function AutoFocusInput() {
	const inputRef = useRef(null);
	useEffect(() => {
		if (inputRef.current) {
			inputRef.current.focus();
		}
	}, []);

	return (
		<div>
			<input ref={inputRef} type='text' placeholder='자동으로 포커스'/>
		</div>
	);
}