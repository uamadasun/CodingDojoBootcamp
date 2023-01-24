import React, { useState } from 'react'
import axios from 'axios';

const ProductForm = () => {
    const [title, setTitle] = useState(""); 
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState("");

    const onSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/product/create', {
            title,
            price, 
            description
        })
            .then(res=>console.log(res))
            .catch(err=>console.log(err))
    }
    return (
        <div className='container mt-5'>
            <h1>Product Manager</h1>
            <form onSubmit={onSubmitHandler} className="form ">
                <p>
                    <label>Title: </label><br/>
                    <input type="text" onChange={(e)=>setTitle(e.target.value)} value={title}/>
                </p>
                <p>
                    <label>Price: </label><br/>
                    <input type="number" onChange={(e)=>setPrice(e.target.value)} value={price}/>
                </p>
                <p>
                    <label>Description: </label><br/>
                    <input type="textarea" onChange={(e)=>setDescription(e.target.value)} value={description}/>
                </p>
                <input type="submit" value="Create"/>
            </form>


        </div>
        
    )
}

export default ProductForm;
