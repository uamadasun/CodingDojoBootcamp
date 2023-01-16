import React, { useContext } from  'react';
import Context from '../Context';


const Form = () => {
    // const [name, setName] = useState("");
    // console.log(name);
    const context = useContext(Context);

    const newName = (e) => {
        context.setName(e.target.value);
        // console.log(context.name)
    }


    return(
        <div className='container mt-5'>
            <form className='form'>
                <label>Your Name: </label>
                <input type='text' onChange = {e => {newName(e)}}/>
            </form>
        </div>

    )
}

export default Form;