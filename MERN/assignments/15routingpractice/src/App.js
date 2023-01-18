import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import React from "react";
import Home from './components/Home';
import {
  Routes,
  Route,
  Link
} from "react-router-dom";
import { useParams } from "react-router"; 
import Word from './components/Word';
import Style from './components/Style';


function App() {
  return (
    <div className="App container mt-5">

        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/:word" element={<Word/>} />
          <Route path="/:word/:fontColor/:bcgColor" element={<Style/>} />
        </Routes>
      
    </div>
  );
}

export default App;
