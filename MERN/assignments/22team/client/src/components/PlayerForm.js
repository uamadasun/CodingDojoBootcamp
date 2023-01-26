import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';


const PlayerForm = (props) => {
    const [name, setName] = useState(""); 
    const [position, setPosition] = useState("");
    const [errors, setErrors] = useState([])
    const navigate = useNavigate();
    


    const onSubmitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/players/', {
            name, position
        })
            .then(res=>{
                navigate('/players/list')

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
                // console.log(errors);
                
                
            }) 
    }
    return (
        <div className='container mt-5'>
            <h1>Add Player</h1>
            <form onSubmit={onSubmitHandler} className="form ">
                <div>
                {errors.map((err, index) => <p key={index} className="text-danger">{err}</p>)}
                </div>
            
                <p>
                    <label>Name: </label><br/>
                    <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
                </p>
                <p>
                    <label>Preferred Position: </label><br/>
                    <input type="text" onChange={(e)=>setPosition(e.target.value)} value={position}/>
                </p>
                <input type="submit" value="Submit" className = {(name.length > 1) ? "btn btn-primary" : "btn btn-primary disabled"}/>
            </form>

        </div>
        
    )
}

export default PlayerForm;
