import { useDispatch, useSelector } from 'react-redux';
import { increment, decrement, incrementByAmount } from "./counterSlice";

function App() {
    const count  = useSelector((state) => state.counter.count);
    const dispatch = useDispatch();

    return (
        <>
        <h1>Counter: {count}</h1>
        <button onClick={(e) => dispatch(increment())}>Increment</button>
        <button onClick={(e) => dispatch(decrement())}>Decrement</button>
        <button onClick={(e) => dispatch(incrementByAmount(5))}>Increment By 5</button>
        </>
    );
}

export default App;
