import React, { useState } from  'react';

const Form = (props) => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setconfirmPassword] = useState("");

    const makeUser = (e) => {
        e.preventDefault();
        const newUser = {firstName, lastName, email, password, confirmPassword};
        console.log(newUser);
    }

    return(
        <div>
            <form onSubmit={makeUser} className="form">
                <div>
                    <label>First Name</label>
                    <input type="text" onClick={(e) => setFirstName(e.target.value)}/>
                </div>

                <div>
                    <label>Last Name</label>
                    <input type="text" onClick={(e) => setLastName(e.target.value)}/>
                </div>

                <div>
                    <label>Email</label>
                    <input type="text" onClick={(e) => setEmail(e.target.value)}/>
                </div>

                <div>
                    <label>Password</label>
                    <input type="password" onClick={(e) => setPassword(e.target.value)}/>
                </div>

                <div>
                    <label>Confirm Password</label>
                    <input type="password" onClick={(e) => setconfirmPassword(e.target.value)}/>
                </div>
                <input type="submit" value="Create New User"/>

            </form>

            <h3>Your Form Data</h3>
            <p> First Name: {firstName}</p>
            <p> Last Name: {lastName}</p>
            <p> Email: {email}</p>
            <p> Password: {password}</p>
            <p> Confirm Password: {confirmPassword}</p>
        </div>
    )
}

export default Form;