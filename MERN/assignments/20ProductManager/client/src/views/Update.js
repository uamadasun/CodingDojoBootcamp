import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link } from "react-router-dom";
    
const Update = (props) => {
    const { _id } = useParams();
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState('');
    
    useEffect(() => {
        axios.get('http://localhost:8000/product/one/' + _id)
            .then(res => {
                setTitle(res.data.title);
                setPrice(res.data.price);
                setDescription(res.data.description);
            })
    }, []);
    
    const UpdateProduct = e => {
        e.preventDefault();
        console.log(title);
        console.log(price);
        console.log(_id)
        axios.put('http://localhost:8000/product/one/' + _id, {
            title,
            price,
            description
        })
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }
    
    return (
        <div className='container mt-5'>
            <h1>Update a Product</h1>
            <form onSubmit={UpdateProduct}>
                <p>
                    <label>Title</label><br />
                    <input type="text" 
                    name="title" 
                    value={title} 
                    onChange={(e) => setTitle(e.target.value) } />
                </p>
                <p>
                    <label>Price</label><br />
                    <input type="number" 
                    name="price"
                    value={price} 
                    onChange={(e) => setPrice(e.target.value) } />
                </p>
                <p>
                    <label>Description</label><br />
                    <input type="text" 
                    name="description" 
                    value={description} 
                    onChange={(e) => setDescription(e.target.value) } />
                </p>
                <input type="submit" />
            </form>
        <Link to="/products" > All products </Link>
        </div>
    )
}
    
export default Update;