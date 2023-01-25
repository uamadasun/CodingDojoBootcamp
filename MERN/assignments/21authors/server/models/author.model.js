const mongoose = require('mongoose');
const AuthorSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "Author {PATH} is required."],
        minlength: [3, "Author {PATH} must be at least 3 characters. "]
    }
}, {timestamps: true});

module.exports.Author = mongoose.model('Author', AuthorSchema)