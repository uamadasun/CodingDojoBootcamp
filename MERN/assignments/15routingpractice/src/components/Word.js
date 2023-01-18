import React from "react";
// import { Routes, Route, Link} from "react-router-dom";
import { useParams } from "react-router"; //Top of App.js

const Word = () => {
    const { word } = useParams();

    return(
        isNaN(+`${word}`) ? <h1>The word is { word }. </h1> : <h1>The number is { word }. </h1>

        
    )

}
export default Word;