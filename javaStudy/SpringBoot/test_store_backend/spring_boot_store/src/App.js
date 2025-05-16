import logo from './logo.svg';
import './App.css';
import "./Style.css";
import { Route, Routes } from 'react-router-dom';
import MainLayout from './MainLayout';
import ProductList from './ProductList';
import ProductForm from './ProductForm';
import ProductDetails from './ProductDetails';
import ProductUpdate from './ProductUpdate';


function App() {
  return (
	<>
	<Routes>
		<Route path='/' element={<MainLayout/>}>
			<Route index element={<ProductList/>}></Route>
			<Route path='/list/:productid' element={<ProductDetails/>}></Route>
			<Route path='/update/:productid' element={<ProductUpdate/>}></Route>
			<Route path='/newproduct' element={<ProductForm/>}></Route>
		</Route>
	</Routes>
	</>
  );
}

export default App;
