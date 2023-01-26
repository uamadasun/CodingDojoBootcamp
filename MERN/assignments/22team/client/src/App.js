import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Main from './views/Main';
import {
  Routes,
  Route,
  Link
} from "react-router-dom";
import StatusBoard from './views/StatusBoard';
import Create from './views/Create';

function App() {
  return (
    <div className="App">
      
      <Routes>
            <Route element={<Main/>} path="/players/list" />
            {/* <Route element={<Update />} path="/author/edit/:_id"/> */}
            <Route element={<Create />} path="player/create/"/>
            <Route element={<StatusBoard />} path="players/game/:number"/>

        </Routes>  
    </div>
  );
}

export default App;
