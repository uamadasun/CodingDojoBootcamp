import React, {useEffect} from "react";
// import { Routes, Route, Link} from "react-router-dom";
import { useParams } from "react-router-dom"; //Top of App.js
import axios from "axios";
import { useState } from "react";


const API = (props) => {
    const [data, setData] = useState([]);
    
    const { category, id } = useParams();
    useEffect( ()=>{
        axios.get(`https://swapi.dev/api/${category}/${id}`)
        .then(res => {
            console.log(res);
            setData(res.data)
            
        })
    }, [ category, id ])

    

    return(
        <div>
            {data === null}
            {data.name}

        </div>
    )

}
export default API;