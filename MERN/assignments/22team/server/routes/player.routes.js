const PlayerController = require("../controllers/player.controller");
module.exports = function(app){
    app.get("/api/players", PlayerController.getPlayers);
    app.post("/api/players/", PlayerController.createPlayer);
    // app.get("/api/author/:_id", AuthorController.findOneAuthor);
    app.put('/api/player/:_id', PlayerController.updateOne);
    app.delete('/api/player/:_id', PlayerController.deletePlayer);
}