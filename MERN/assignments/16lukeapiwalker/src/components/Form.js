import React from "react";
import { useState } from "react";
import {useNavigate} from "react-router-dom"

const Form = (props) => {
    const [category, setCategory] = useState("people");
    const [id, setId] = useState(1);
    const navigate = useNavigate();

    const handleForm = (e) => {
        e.preventDefault();
        // console.log(category)
        // console.log(id)
        navigate(`/${category}/${id}`)
        
    }

    return(
        <div className="container mt-5 justify-content-around">
            <form className="form-control p-2" onSubmit={handleForm}>
            <select value={category} onChange={e => setCategory(e.target.value) }>
                <option selected value="people"> People </option>
                <option value="planets" > Planets </option>
                <option value="spaceships"> Spaceships </option>
                <option value="vehicles"> Vehicles </option>
                <option value="species"> Species </option>
                <option value="films"> Films </option>
            </select>
            <input  type="number" value={id} onChange={e => setId(e.target.value) } />
            <button className="btn btn-warning">Search</button>
                
            </form>

        </div>
    )
}
export default Form;