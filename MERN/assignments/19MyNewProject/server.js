const express = require("express");
const app = express();
const port = 8000;
const cors = require('cors');
require('./server/config/mongoose.config');
app.use(cors());
app.use(express.json()); 
app.use(express.urlencoded({ extended: true }));

require('./server/routes/person.route')(app);

app.listen(port, () => console.log(`Listening on port ${port}`));