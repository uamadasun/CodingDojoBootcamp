import axios from 'axios';
import React, { useEffect, useState } from 'react'
// import AuthorForm from '../components/AuthorForm';
import PlayerList from '../components/PlayerList';
import {Link, useParams} from 'react-router-dom'

const Main = () => {
    const {paramNumber} = useParams;
    const [players, setPlayers] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const [games, setGames] = useState([
        {
        number: 1,
        players:[]
        }, 
        {
            number: 2,
            players:[]
            },
        {
            number: 3,
            players:[]
            }])
    const [currentGame, setCurrentGame] = useState(null)
        
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
                <Link to="/players/list"><h2 className='btn btn-dark'> Manage Players</h2></Link>  
                {/* <h1> | </h1> */}
                <Link to="/players/game/1"><h2 className='btn btn-success'>Manage Player Status</h2></Link>
            </div>


            <div className='d-flex justify-content-center'>
            {games.map((game, idx) => 
                <Link to={`/players/game/${game.number}`} key={idx} > 
                    <button value={game.number} > Game {game.number}
                    </button>
                </Link>
                
            )}
            </div>
            

            
            
            <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">Player Name</th>
                            <th scope="col">Actions Available</th>
                        </tr>
                    </thead>
                    <tbody>
                    {players.map( (player, i) =>
                
                        <tr>
                            <td>
                            {player.name}
                            </td>
                            <td>
                            {/* Maybe a form here with 3 buttons and on submit, the player's status is changed */}
                            </td>

                        </tr>
                    )}
                    </tbody>
            </table>

                
                    


        </div>
    )
}
export default Main;