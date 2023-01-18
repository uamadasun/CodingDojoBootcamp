import React from "react";
// import { Routes, Route, Link} from "react-router-dom";
import { useParams } from "react-router"; //Top of App.js

const Style = () => {
    const { word, fontColor, bcgColor } = useParams();

    return(
        <div style={{color:fontColor, backgroundColor:bcgColor}}>
            <h1>The word is: {word}.</h1>

        </div>

        
    )

}
export default Style;