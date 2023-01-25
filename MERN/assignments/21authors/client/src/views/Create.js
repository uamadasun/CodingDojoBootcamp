import axios from "axios";
import { useEffect, useState } from "react";
import AuthorForm from "../components/AuthorForm";
import { Link } from "react-router-dom";

const Create = () => {
    // // const [authors, setAuthors] = useState([])
    // const [errors, setErrors] = useState([]); 

    // const createAuthor = author => {
    //     axios.post('http://localhost:8000/api/authors', author)
    //         .then(res =>{
    //             console.log(res.data);
    //         })
    //         .catch(err=>{
    //             const errorResponse = err.response.data.errors;

    //             const errorArr = []; // Define a temp error array to push the messages in
    //             for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
    //                 errorArr.push(errorResponse[key].message)
    //             }
    //             // Set Errors
    //             setErrors(errorArr);
    //         })
    // }

    // return(
    //     <div>
    //         <Link to='/authors'>Home</Link>
    //         <AuthorForm onSubmitProp={createAuthor} initialName = "" 
    //         />
    //     </div>
    // )
    return(
        <AuthorForm/>
    )
}

export default Create;