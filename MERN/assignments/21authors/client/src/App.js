import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Main from './views/Main';
import {
  Routes,
  Route,
} from "react-router-dom";
import Update from './views/Update';
import Create from './views/Create'

function App() {
  return (
    <div className="App">
      <Routes>
            <Route element={<Main/>} path="/authors" />
            <Route element={<Update />} path="/author/edit/:_id"/>
            <Route element={<Create />} path="author/create/"/>
        </Routes>  
    </div>
  );
}

export default App;
