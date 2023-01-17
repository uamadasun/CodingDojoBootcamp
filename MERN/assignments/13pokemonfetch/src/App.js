import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React, { useState } from 'react';

//allPokemon doesn't show up as multiple pokemon objects, just as one object that is an array of objects
//says we should get 807 of them?? only shows up 20
function App() {

  const [allPokemon, setAllPokemon] = useState([]);

  
  const  getPokemon = () => {
    fetch("https://pokeapi.co/api/v2/pokemon")
          .then(response => {
            // not the actual JSON response body but the entire HTTP response
            return response.json();
        }).then(response => {
            // we now run another promise to parse the HTTP response into usable JSON
            // setAllPokemon(response)
            // console.log(response.results);
            let listPokemon = response.results
            // listPokemon.map((pokemon) => setAllPokemon([...allPokemon, {pokemon}]))
            setAllPokemon(listPokemon)
            // console.log(typeof listPokemon)
            console.log(`all pokemon ${allPokemon}`)
            
        }).catch(err=>{
            console.log(err);
        });
        
  }
  return (

    

    <div className="App container mt-5">
      <button className='btn btn-warning' onClick={getPokemon}> Get Pokemon</button>
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
