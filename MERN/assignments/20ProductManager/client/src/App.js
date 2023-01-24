import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Main from './views/Main';
import {
  Routes,
  Route,
} from "react-router-dom";
import Detail from './views/Detail';
import Update from './views/Update';

function App() {
  return (
    <div className="App">
      <Routes>
            <Route element={<Main/>} path="/products" />
            <Route element={<Detail/>} path="/product/one/:_id" />
            <Route element={<Update />} path="/product/edit/:_id"/>
        </Routes>  
    </div>
  );
}

export default App;
