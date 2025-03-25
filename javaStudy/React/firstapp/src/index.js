import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

//getElementById('root')를 루트로 삼는 가상 dom을 만들겠다. 
const root = ReactDOM.createRoot(document.getElementById('root')); 
root.render( //그리고 얘를 렌더링 하겠다.
  <React.StrictMode>
    <App />
  </React.StrictMode>
);


// -------------------------------------------------------------------
// [noti]
// - App라는 컴포넌트
// - 태그를 만들어서 리턴해주는 함수를 컴포넌트라고 명령한다.


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
