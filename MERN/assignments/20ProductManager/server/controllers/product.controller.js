const {Product} = require('../models/product.model')

module.exports.getProducts = (req, res) => {
    Product.find()
        .then(results => res.json(results))
        .catch(err => res.status(400).json({message: "unable to get all products", err}));
}

module.exports.createProduct = (req, res) => {
    const {title, price, description} = req.body;
    Product.create({title, price, description})
    .then(product => res.json(product))
    .catch(err => res.status(400).json({message: "unable to create product", err}));
}