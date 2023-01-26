import axios from 'axios';
import React, { useEffect, useState } from 'react'
// import AuthorForm from '../components/AuthorForm';
import PlayerList from '../components/PlayerList';
import {Link} from 'react-router-dom'
import NavBar from '../components/NavBar';

const Main = () => {
    const [players, setPlayers] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/players')
            .then(res => {
                setPlayers(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = playerId => {
        setPlayers(players.filter(player => player._id !== playerId));
    }
    
    
    return(
        <div className='container mt-5'>
            <div className="d-flex justify-content-center">
                <Link to="/players/list"><h2 className='btn btn-success'> Manage Players</h2></Link>  
                <h1> | </h1>
                <Link to="/players/game/1"><h2 className='btn btn-dark'>Manage Player Status</h2></Link>
            </div>

            <div className='d-flex justify-content-center'> 
                <Link to="/players/list"> <h4 className='text-danger font-weight-boldest'> List </h4> </Link> |
                <Link to="/player/create"><h4>Add Player </h4>  </Link>
            </div>
            
            
            <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">Player Name</th>
                            <th scope="col">Preferred Position</th>
                            <th scope="col">Action Available</th>
                        </tr>
                    </thead>
            </table>
            {loaded && <PlayerList players = {players} removeFromDom={removeFromDom}/>}
        </div>
    )
}
export default Main;