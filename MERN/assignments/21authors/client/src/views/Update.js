import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link, useNavigate } from "react-router-dom";


const Update = () => {
    const { _id } = useParams();
    const [name, setName] = useState('');
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    
    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + _id)
            .then(res => {
                setName(res.data.name);
            })
    }, [_id]);
    
    const UpdateAuthor = e => {
        e.preventDefault();
        axios.put('http://localhost:8000/api/author/' + _id, {
            name
        })
            .then(res=>{
                navigate('/authors')

            })
            .catch(err=>{
                const errorResponse = err.response.data.err.errors; // Get the errors from err.response.data
                const errorArr = []; //; Define a temp error array to push the messages in
                // console.log(errorResponse)
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // console.log(errorArr)
                setErrors(errorArr);
                console.log(err);
                
                
            })
    }
    
    return (
        <div className='container mt-5'>
            <h1>Edit this Author</h1>
            <form onSubmit={UpdateAuthor}>
            {errors.map((err, index) => <p key={index} className="text-danger">{err}</p>)}
                <p>
                    <label>Name</label><br />
                    <input type="text" 
                    name="name" 
                    value={name} 
                    onChange={(e) => setName(e.target.value) } />
                </p>
                <input type="submit" className='btn btn-primary'/>
                <Link to="/authors"> <button className='btn btn-secondary'> Cancel </button>  </Link>
            </form>
        </div>
    )

}

export default Update;