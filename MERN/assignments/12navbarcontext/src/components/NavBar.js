import React, { useContext } from  'react';
import Context from '../Context';

// ask about aligning nav bar text right
//is this how this app is meant to function (no submit, nav bar updating on change)

const NavBar = () => {
    const context = useContext(Context);

    return(
        <div className="container mt-5 text-end">
            <nav className="navbar navbar-light bg-primary">
                <p className="navbar-brand mb-0 h1 text-white"> {context.name ? `Hi, ${context.name}!`:""} </p>
            </nav>
        </div>
    )

}

export default NavBar;