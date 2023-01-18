import React from "react";
import { Routes, Route, Link} from "react-router-dom";

const Home = () => {

    return(
        <div className="container mt-5">
            <h1>Welcome!</h1>
            <Link to={"/"}>Go Home</Link> 
        </div>
        
    )

}
export default Home;