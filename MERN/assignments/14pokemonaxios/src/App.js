import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React, { useState } from 'react';
import axios from 'axios';
// import GetPokemon from './components/GetPokemon';

//allPokemon doesn't show up as multiple pokemon objects, just as one object that is an array of objects
//says we should get 807 of them?? only shows up 20
function App() {

  const [allPokemon, setAllPokemon] = useState([]);

  const GetPokemon = () => {
        axios.get('https://pokeapi.co/api/v2/pokemon?limit=808')
        .then(response=>{setAllPokemon(response.data.results)})
    }; 



  return (
    <div className="App container mt-5">
      <button className='btn btn-warning' onClick={GetPokemon}> Get Pokemon</button>
            {allPokemon.map((pokemon, idx) =>
            <div key={idx}> 
                    <ul className="list-group mt-3">
                        <li className="list-group-item row g-1">
                            {pokemon.name}
                        </li>
                    </ul>
            </div>
            )}
      
    </div>
  );
}

export default App;
