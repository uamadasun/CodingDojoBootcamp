import React from 'react'
import { Link } from 'react-router-dom';
// import DeleteButton from './DeleteButton';
import axios from 'axios';
    
const PlayerList = (props) => {
    // const {removeFromDom} = props;
    const {players, removeFromDom} = props;
    console.log(players)

    const deletePlayer = (playerId) => {
        axios.delete('http://localhost:8000/api/player/'+ playerId)
        .then(res => {
            removeFromDom(playerId)
        })
        .catch(err => console.log(err));
    }


    return (
        <div>
            {players.map( (player, i) =>
            <div key={i} className='mt-5 d-flex justify-content-around'>

                <table className="table table-hover">
                    <tbody>
                        <tr>
                            <td>{player.name}</td>
                            <td>{player.position}</td>
                            <td>
                                <button className="btn btn-outline-danger" onClick={ (e) => {deletePlayer(player._id)}}> 
                                    Delete 
                                </button> 
                            </td>
                        
                        </tr>
                    </tbody>
                </table>
            </div>
            )}
        </div>
    )
}
    
export default PlayerList;