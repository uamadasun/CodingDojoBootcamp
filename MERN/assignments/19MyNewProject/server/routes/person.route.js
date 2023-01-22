const personController = require('../controllers/person.controller');

module.exports = function(app){
    app.get("/api", personController.index);
}