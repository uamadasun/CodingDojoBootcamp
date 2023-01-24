import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate } from "react-router-dom";
import PersonForm from '../components/PersonForm';
import DeleteButton from '../components/DeleteButton';
    
const Update = (props) => {
    const { _id } = useParams();
    const navigate = useNavigate();
    const [person, setPerson] = useState();
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/people/' + _id)
            .then(res => {
                setPerson(res.data);
                setLoaded(true);
            })
    }, [_id])
        
    const UpdatePerson = person => {
        axios.put('http://localhost:8000/api/people/' + _id, person)
            .then(res => console.log(res));
    }
    
    return(
        <div>
            {loaded && (
                <>
                    <PersonForm
                        onSubmitProp={UpdatePerson}
                        initialFirstName={person.firstName}
                        initialLastName={person.lastName}
                    />
                    <DeleteButton personId={person._id} successCallback={() => navigate("/people")} />
                </>
            )}

        </div>
        
    )
}
    
export default Update;