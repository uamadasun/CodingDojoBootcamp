import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React from "react";
import {
  Routes,
  Route,
} from "react-router-dom";
import Form from './components/Form';
import API from './components/API';

function App() {
  


  return (
    <div className="App">
      <Form />
      <Routes>
        <Route path="/:category/:id" element={<API/>}/>
      </Routes>

    </div>
  );
}

export default App;
