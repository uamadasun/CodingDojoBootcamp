const express = require("express");
const app = express();
const port = 8000;
const { faker } = require('@faker-js/faker');

const createUser = () => {
    const user = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        lastName: faker.name.lastName(),
        firstName: faker.name.firstName(),
        _id:  faker.datatype.uuid()
    };
    return user;
};
    
const createCompany = () => {
    const company = {
        _id:  faker.datatype.uuid(),
        name: faker.company.name(),
        address: {
            street: faker.address.street(),
            city: faker.address.city(),
            state: faker.address.state(),
            zipCode: faker.address.zipCode(),
            country: faker.address.country(),
        }
        
    };
    return company;
};

const newUser = createUser();

const newCompany = createCompany();


//get fake user
app.get("/api/users/new", (req, res) => {
    res.json( newUser );
});

//get fake company
app.get("/api/companies/new", (req, res) => {
    res.json( newCompany );
});

//get fake user and company
app.get("/api/user/company", (req, res) => {
    res.json( {newCompany, newUser} );
});


app.listen( port, () => console.log(`Listening on port: ${port}`) );

