import axios from "axios";
import { Link } from "react-router-dom";

const NavBar = () => {

    return(
        <div className="d-flex justify-content-center">
        <Link to="/players/list"><h2> Manage Players</h2></Link>  
        <h1> | </h1>
        <Link to="/players/list"><h2>Manage Player Status</h2></Link>
        </div>
        
    )

}
export default NavBar;