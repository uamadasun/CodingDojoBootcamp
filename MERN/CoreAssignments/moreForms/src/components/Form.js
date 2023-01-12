import React, { useState } from  'react';

const Form = (props) => {
    const [firstName, setFirstName] = useState("");
    const [firstNameError, setFirstNameError] = useState("");

    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState("");

    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");

    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");


    const [confirmPassword, setConfirmPassword] = useState("");
    const [confirmPasswordError, setConfirmPasswordError] = useState("");

    //ask about how to have the error disappear when person is not typing, why password matching validation doesn't work,
    //and is this the way we were suppposed to do this with all this repeating code?
    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        if (firstName.length < 2) {
            setFirstNameError("First name should be longer than 2 characters, try again.");
        } else{
            setFirstNameError("");
        }
    }

    const handleLastName = (e) => {
        // if(lastName.length <= 0) {
        //     setLastNameError("");
        // }
        setLastName(e.target.value);
        if (lastName.length < 2) {
            setLastNameError("Last name should be at least 2 characters long, try again.");
        } else{
            setLastNameError("");
        }
    }

    const handleEmail = (e) => {
        setEmail(e.target.value);
        if (email.length < 5) {
            setEmailError("Email should be at least 5 characters long, try again.");
        } else{
            setEmailError("");
        }
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
        if (password.length < 8) {
            setPasswordError("Password should be at least 8 characters long, try again.");
        } else{
            setPasswordError("");
        }
    }

    const handleConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        if (confirmPassword !== password) {
            setConfirmPasswordError( "Passwords must match.");
        } else{
            setConfirmPassword("");
        }
        
    }


    const makeUser = (e) => {
        e.preventDefault();
        const newUser = {firstName, lastName, email, password, confirmPassword};
        console.log(newUser);
    }

    return(
        <div>
            <form onSubmit={ firstNameError || lastNameError || emailError || passwordError || confirmPasswordError ?  (e) => e.preventDefault() : makeUser} className="form">
                <div>
                    <label>First Name</label>
                    <input type="text" onChange={handleFirstName}/>
                    {firstNameError ? <p style={{color:'red'}}>{ firstNameError }</p> : ""}
                </div>

                <div>
                    <label>Last Name</label>
                    <input type="text" onChange={handleLastName}/>
                    {lastNameError ? <p style={{color:'red'}}>{ lastNameError }</p> : ""}
                </div>

                <div>
                    <label>Email</label>
                    <input type="text" onChange={handleEmail}/>
                    {emailError ? <p style={{color:'red'}}>{ emailError }</p> : ""}
                </div>

                <div>
                    <label>Password</label>
                    <input type="password" onChange={handlePassword}/>
                    {passwordError ? <p style={{color:'red'}}>{ passwordError }</p> : ""}
                </div>

                <div>
                    <label>Confirm Password</label>
                    <input type="password" onChange={handleConfirmPassword}/>
                    {confirmPasswordError ? <p style={{color:'red'}}>{ confirmPasswordError }</p> : ""}
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