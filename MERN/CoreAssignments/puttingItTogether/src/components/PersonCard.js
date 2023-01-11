import React, { Component } from 'react';

class PersonCard extends Component {

    constructor(props) {
        super(props);
        this.state = {
            updatedAge: this.props.people.age
        };
    }

    addAge = () => {
        console.log(this.state.updatedAge)
        this.setState({updatedAge:this.state.updatedAge + 1})
    }
    
    render() {
        return(
            <div className="font-link">

                <h1> {this.props.people.lastName}, {this.props.people.firstName}</h1>
                <p>Age: {this.state.updatedAge}</p>
                <p>Hair Color: {this.props.people.hairColor}</p>
                <button onClick={this.addAge}> Birthday Button for {this.props.people.firstName} {this.props.people.lastName}</button>

            </div>
        )
    }
}
export default PersonCard;