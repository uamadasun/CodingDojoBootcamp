const {Author} = require('../models/author.model')

module.exports.getAuthors = (req, res) => {
    Author.find()
        .then(authors => res.json(authors))
        .catch(err => res.status(400).json({message: "unable to get all authors", err}));
}

module.exports.createAuthor = (req, res) => {
    const {name} = req.body;
    Author.create({name})
    .then(createdAuthor => res.json(createdAuthor))
    .catch(err => res.status(400).json({message: "unable to create author", err}));
}

module.exports.findOneAuthor = (req, res) => {
    Author.findOne({_id: req.params._id})
        .then(foundAuthor => res.json(foundAuthor))
        .catch(err => res.status(400).json({message: "unable to find author", err}));
}

module.exports.updateOne = (req, res) => {
    Author.findOneAndUpdate({_id: req.params._id}, req.body, {runValidators:true})
        .then(updatedAuthor => res.json(updatedAuthor))
        .catch(err => res.status(400).json({message: "unable to update author", err}));
}

module.exports.deleteAuthor = (req, res) => {
    Author.deleteOne({ _id: req.params._id })
        .then(deleteConfirmation => res.json(deleteConfirmation))
        .catch(err => res.json({message: "unable to delete author", err}))
}