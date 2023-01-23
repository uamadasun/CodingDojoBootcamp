const ProductController = require("../controllers/product.controller");
module.exports = function(app){
    app.get("/api/products", ProductController.getProducts);
    app.post("/api/product/create", ProductController.createProduct);
}