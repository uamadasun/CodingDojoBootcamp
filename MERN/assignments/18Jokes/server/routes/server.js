const express = require('express');
const app = express();
const port = 8000;
require('../config/mongoose.config');
app.use(express.json(), express.urlencoded({ extended: true}));
const allJokesRoutes = require('../routes/jokes.routes');
allJokesRoutes(app);

 



const server = app.listen(port, () => console.log(`Server is locked and loaded on port ${port}!`))