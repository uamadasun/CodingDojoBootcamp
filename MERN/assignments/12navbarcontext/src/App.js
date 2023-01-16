import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React, { useState } from  'react';
import Context from './Context';
import NavBar from './components/NavBar';
import FormWrapper from './components/FormWrapper';

function App() {
  const[name, setName] = useState("");


  return (
    <div className="App">
      <Context.Provider value={{name, setName}}>
        <NavBar/>
        <FormWrapper/>
      </Context.Provider>
        
    </div>
  );
}

export default App;
