const AuthorController = require("../controllers/author.controller");
module.exports = function(app){
    app.get("/api/authors", AuthorController.getAuthors);
    app.post("/api/authors/", AuthorController.createAuthor);
    app.get("/api/author/:_id", AuthorController.findOneAuthor);
    app.put('/api/author/:_id', AuthorController.updateOne);
    app.delete('/api/author/:_id', AuthorController.deleteAuthor);
}