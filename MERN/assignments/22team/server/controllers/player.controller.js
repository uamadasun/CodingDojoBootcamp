const {Player} = require('../models/player.model')

module.exports.getPlayers = (req, res) => {
    Player.find()
        .then(players => res.json(players))
        .catch(err => res.status(400).json({message: "unable to get all players", err}));
}

module.exports.createPlayer = (req, res) => {
    const {name, position, status} = req.body;
    Player.create({name, position, status})
    .then(createdPlayer => res.json(createdPlayer))
    .catch(err => res.status(400).json({message: "unable to create player", err}));
}

// module.exports.findOnePlayer = (req, res) => {
//     Player.findOne({_id: req.params._id})
//         .then(foundPlayer => res.json(foundPlayer))
//         .catch(err => res.status(400).json({message: "unable to find player", err}));
// }

module.exports.updateOne = (req, res) => {
    Player.findOneAndUpdate({_id: req.params._id}, req.body, {runValidators:true})
        .then(updatedPlayer => res.json(updatedPlayer))
        .catch(err => res.status(400).json({message: "unable to update player", err}));
}

module.exports.deletePlayer = (req, res) => {
    Player.deleteOne({ _id: req.params._id })
        .then(deleteConfirmation => res.json(deleteConfirmation))
        .catch(err => res.json({message: "unable to delete player", err}))
}