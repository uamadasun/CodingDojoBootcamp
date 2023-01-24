import React from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import DeleteButton from './DeleteButton';
    
const PersonList = (props) => {
    const { removeFromDom } = props;
    
    // const deletePerson = (personId) => {
    //     axios.delete('http://localhost:8000/api/people/' + personId)
    //         .then(res => {
    //             removeFromDom(personId)
    //         })
    //         .catch(err => console.error(err));
    // }
    
    return (
        <div>
            {props.people.map((person, idx) => {
                return <p key={idx}>
                    <Link to={`/people/${person._id}`}>
                        {person.lastName}, {person.firstName}
                    </Link>
                    |
                    <DeleteButton personId={person._id} successCallback={()=>removeFromDom(person._id)}/>
                </p>
            })}
        </div>
    )
}
    
export default PersonList;