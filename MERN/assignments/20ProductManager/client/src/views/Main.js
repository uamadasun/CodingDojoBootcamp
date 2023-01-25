import axios from 'axios';
import React, { useEffect, useState } from 'react'
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';

const Main = () => {
    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/products')
            .then(res => {
                setProducts(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, [products]);

    const removeFromDom = productId => {
        setProducts(products.filter(product => product._id !== productId));
    }

    const createProduct = product => {
        axios.post('http://localhost:8000/product/create', product)
            .then(res =>{
                setProducts([...products, res.data]);
            })
    }
    
    return(
        <div>
            <ProductForm onSubmitProp={createProduct} initialTitle = "" 
            initialPrice={0} initialDescription=""/>
            <hr/>
            {loaded && <ProductList products = {products} removeFromDom={removeFromDom}/>}
        </div>
    )
}
export default Main;