import React, { Component } from 'react';

class PersonCard extends Component {
    
    render() {
        return(
            <div className="font-link">

                {this.props.people.map((person, idx) => {
                    return (
                        <div key={idx}> 
                            <h1> {person.lastName}, {person.firstName}</h1>
                            <p>Age: {person.age}</p>
                            <p>Hair Color: {person.hairColor}</p>
                        </div> 
                    )
                })} 

            </div>
        )
    }
}
export default PersonCard;