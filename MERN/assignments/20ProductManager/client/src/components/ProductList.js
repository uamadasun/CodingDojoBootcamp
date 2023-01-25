import React from 'react'
import { Link } from 'react-router-dom';
import DeleteButton from './DeleteButton';
    
const ProductList = (props) => {
    const {removeFromDom} = props;


    return (
        <div>
            {props.products.map( (product, i) =>
            <div key={i} className='mt-5 d-flex justify-content-around'>
                <Link to={`/product/one/${product._id}`}>{product.title}</Link>
                <DeleteButton productId={product._id} successCallback={()=>removeFromDom(product._id)}/>
            </div>
            )}
        </div>
    )
}
    
export default ProductList;