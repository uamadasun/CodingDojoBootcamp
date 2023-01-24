const {Product} = require('../models/product.model')

module.exports.getProducts = (req, res) => {
    Product.find()
        .then(products => res.json(products))
        .catch(err => res.status(400).json({message: "unable to get all products", err}));
}

module.exports.createProduct = (req, res) => {
    const {title, price, description} = req.body;
    Product.create({title, price, description})
    .then(product => res.json(product))
    .catch(err => res.status(400).json({message: "unable to create product", err}));
}

module.exports.findOneProduct = (req, res) => {
    Product.findOne({_id: req.params._id})
        .then(product => res.json(product))
        .catch(err => res.status(400).json(err));
}

module.exports.updateOne = (req, res) => {
    Product.findOneAndUpdate({_id: req.params._id}, req.body, {runValidators:true})
        .then(updatedProduct => res.json(updatedProduct))
        .catch(err => res.status(400).json({message: "unable to create product", err}));
}

module.exports.deleteProduct = (req, res) => {
    Product.deleteOne({ _id: req.params._id })
        .then(deleteConfirmation => res.json(deleteConfirmation))
        .catch(err => res.json(err))
}