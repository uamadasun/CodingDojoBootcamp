import React from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
    
const ProductList = (props) => {
    // console.log(props.products);
    const {removeFromDom} = props;

    const deleteProduct = (productId) => {
        axios.delete('http://localhost:8000/product/delete/'+ productId)
        .then(res => {
            removeFromDom(productId)
        })
        .catch(err => console.log(err));
    }

    return (
        <div>
            {props.products.map( (product, i) =>
            <div key={i} className='mt-5 d-flex justify-content-around'>
                <Link to={`/product/one/${product._id}`}>{product.title}</Link>
                <button className = "btn btn-danger" onClick={(e)=>{deleteProduct(product._id)}}>
                        Delete
                </button>
            </div>
            )}
        </div>
    )
}
    
export default ProductList;