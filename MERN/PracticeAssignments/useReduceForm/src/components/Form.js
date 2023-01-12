import React, { useReducer } from  'react';

const initialState = {
    firstName: {
        value: '',
        error: null,
    }, 
    lastName: {
        value: '',
        error: null,
    },
    email: {
        value: '',
        error: null,
    },
    password: {
        value: '',
        error: null,
    }, 
    confirmPassword: {
        value: '',
        error: null,
    }
};

function reducer(state, action) {
    console.log(state);
    console.log(action)
    console.log([action.type])
    let error = "";
    if(action.type === "firstName") {
        if(action.payload.length < 2) {
            error = "first name must be at least 2 characters long";
        }
    } else if(action.type === "lastName") {
        if(action.payload.length < 2) {
            error = "last name must be at least 2 characters long";
        }
    } else if(action.type === "email") {
        // eslint-disable-next-line no-useless-escape
        const newRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
        if (! action.payload.match(newRegex) ) {
            error = "email format is invalid";
        }
    } else if(action.type === "password") {
        if (action.payload.length < 8 ) {
            error = "password should be at least 8 characters long";
        } 
    } else if(action.type === "confirmPassword") {
        if (action.payload !== state.password.value){
            error = "passwords must match"
        }
    } 
    
    return {
        ...state,
        [action.type]: {value:action.payload, error:error}
    };
    
}

const Form = () => {
    const [state, dispatch] = useReducer(reducer,initialState);

    function handleChange(e) {
        const { name, value } = e.target;


        dispatch({
            type: name,
            payload: value,
        });
    }

    return (
        <div>

            <div>
                <label>
                    <span>First Name: </span>
                    <input
                        name = "firstName"
                        value = {state.firstName.value}
                        onChange={handleChange}
                    />
                </label>
                {state.firstName.error !== null && (
                    <p style={{color:'red'}}>{state.firstName.error}</p>
                )}
            </div>

            <div>
                <label>
                    <span>Last Name: </span>
                    <input
                        name = "lastName"
                        value = {state.lastName.value}
                        onChange={handleChange}
                    />
                </label>
                {state.lastName.error !== null && (
                    <p style={{color:'red'}}>{state.lastName.error}</p>
                )}
            </div>

            <div>
                <label>
                    <span>Email: </span>{' '}
                    <input
                        name = "email"
                        value = {state.email.value}
                        onChange={handleChange}
                    />
                </label>
                {state.email.error !== null && (
                    <p style={{color:'red'}}>{state.email.error}</p>
                )}

            </div>

            <div>
                <label>
                    <span>Password: </span>{' '}
                    <input
                        name = "password"
                        value = {state.password.value}
                        onChange={handleChange}
                    />
                </label>
                {state.password.error !== null && (
                    <p style={{color:'red'}}>{state.password.error}</p>
                )}
            </div>

            <div>
                <label>
                    <span>Confirm Password: </span>
                    <input
                        name = "confirmPassword"
                        value = {state.confirmPassword.value}
                        onChange={handleChange}
                    />
                </label>
                {state.confirmPassword.error !== null && (
                    <p style={{color:'red'}}>{state.confirmPassword.error}</p>
                )}
            </div>



            <h3>Your Form Data</h3>
                <p> First Name: {state.firstName.value}</p>
                <p> Last Name: {state.lastName.value}</p>
                <p> Email: {state.email.value}</p>
                <p> Password: {state.password.value}</p>
                <p> Confirm Password: {state.confirmPassword.value}</p>
        </div>
    )
}

export default Form;

