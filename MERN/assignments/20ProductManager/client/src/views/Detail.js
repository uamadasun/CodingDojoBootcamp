import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import { Link, useNavigate } from 'react-router-dom';
    
const Detail = (props) => {
    const [product, setProduct] = useState({})
    const { _id } = useParams();
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get('http://localhost:8000/product/one/' + _id)
            .then(res => setProduct(res.data))
            .catch(err => console.error(err));
    }, [_id]);

    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/product/delete/'+ productId)
        .then(res => {
            navigate('/products')
        })
        .catch(err => console.log(err));
    }
    
    return (
        <div className='container mt-5'>
            <h1>{product.title}</h1>
            <p>Price: {product.price}</p>
            <p>Description: {product.description}</p>
            <Link to={`/products`}>Back</Link> | 
            <Link to={`/product/edit/${product._id}`}>Edit</Link>
            <button className = "btn btn-danger" onClick={(e)=>{deleteProduct(product._id)}}>
                        Delete
                </button>
        </div>
    )
}
    
export default Detail;