const mongoose = require('mongoose');
const PlayerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "Player {PATH} is required."],
        minlength: [2, "Player {PATH} must be at least 2 characters. "]
    },
    
    position: String,

    status: {
        type: String,
        default: "undecided"
    }
}, {timestamps: true});

module.exports.Player = mongoose.model('Player', PlayerSchema)