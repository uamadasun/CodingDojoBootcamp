import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from "react-router-dom";
import ProductForm from '../components/ProductForm';
import DeleteButton from '../components/DeleteButton';
    
const Update = (props) => {
    const { _id } = useParams();
    const [product, setProduct] = useState();
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/product/one/' + _id)
            .then(res => {
                
                console.log(res.data);
                setProduct(res.data);
                setLoaded(true);
            })
    }, []);
    
    const UpdateProduct = product => {
        console.log(product)
        axios.put('http://localhost:8000/product/one/' + _id, product)
            .then(res => console.log(res))
            navigate('/products')

    }
    
    return (
        <div className='container mt-5'>
            {loaded && (
                <>
                    <ProductForm onSubmitProp={UpdateProduct}
                    initialTitle = {product.title}
                    initialPrice ={product.price}
                    initialDescription={product.description}
                    />

                    {/* delete button here */}
                    <DeleteButton productId = {product._id} successCallback = {
                        () => navigate('/products')
                    }/>

                </>
            )}
        </div>
    )
}
    
export default Update;