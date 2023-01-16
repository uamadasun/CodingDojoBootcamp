import React, { useState } from 'react';
import Box from './Box';

const Form = () => {
    const [color, setColor] = useState("");
    const [allColors, setAllColors] = useState([]);
    
    const handleSubmit = (e) => {
        e.preventDefault();
        // console.log("from form.js, the color is: " + color);
        setAllColors([...allColors, color]);
        // console.log("from form.js, all colors: " + [...allColors, color]);
    }


    return(
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Color</label>
                    <input type="text" onChange={(e) => setColor(e.target.value)} />
                    <input type="submit" value="Add" className="btn-primary"/>
                </div>
            </form>

            <div> 
                {allColors.map((item,i) => 
                    <div key = {i} className = "d-inline-flex align-content-middle">
                    <Box color={item}/>
                    </div>
                )}
            </div>


        </div>

    )
}

export default Form;