const ProductController = require("../controllers/product.controller");
module.exports = function(app){
    app.get("/products", ProductController.getProducts);
    app.post("/product/create", ProductController.createProduct);
    app.get("/product/one/:_id", ProductController.findOneProduct);
    app.put('/product/one/:_id', ProductController.updateOne);
    app.delete('/product/delete/:_id', ProductController.deleteProduct);
}