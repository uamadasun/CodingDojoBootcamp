import axios from 'axios';
import React, { useEffect, useState } from 'react'
// import AuthorForm from '../components/AuthorForm';
import {Link} from 'react-router-dom'
import NavBar from '../components/NavBar';
import PlayerForm from "../components/PlayerForm";

const Create = () => {
    return(
        <div className='container mt-5'>
            
            <div className="d-flex justify-content-center">
                <Link to="/players/list"><h2 className='btn btn-success'> Manage Players</h2></Link>  
                <h1> | </h1>
                <Link to="/players/game/1"><h2 className='btn btn-dark'>Manage Player Status</h2></Link>
            </div>


            <div className='d-flex justify-content-center'> 
                <Link to="/players/list"> <h4 > List </h4> </Link> |
                <Link to="/player/create"> <h4 className='text-danger font-weight-boldest'> Add Player </h4> </Link>
            </div>

            <PlayerForm/>

        </div>
    )
}

export default Create;