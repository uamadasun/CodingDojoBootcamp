const Joke = require('../models/jokes.model');

module.exports.findAllJokes = (req, res) => {
    Joke.find()
    .then((allJokes) => {
        res.json({allJokes})
    })
    .catch( (err) => {
        res.json({message: 'Something went wrong', error: err})
    });
}

module.exports.findOneJoke = (req, res) => {
    Joke.findOne({ _id: req.params.id })
    .then(oneSingleJoke => {
        res.json( { joke: oneSingleJoke })
    })
    .catch( (err) => {
        res.json( {message: 'Something went wrong', error: err})
    } );
}

//TO-DO GET RANDOM JOKE ROUTE
module.exports.getRandomJoke = (req, res) => {
    Joke.aggregate([{$sample: {size:1}}])
    .then(randomJoke => {
        res.json({joke:randomJoke})
    })
    .catch( (err) => {
        res.json( {message: 'Something went wrong', error: err})
    });
}

module.exports.createNewJoke = (req,res) => {
    Joke.create(req.body)
    .then(newJoke => {
        res.json({ joke: newJoke })
    })
    .catch( (err) => {
        res.json({message: 'Something went wrong', error: err})
    });
}

module.exports.updateExistingJoke = (req, res) => {
    Joke.findOneAndUpdate(
        {_id: req.params.id}, 
        req.body,
        { new: true, runValidators: true }
        )
        .then(updatedJoke => {
            res.json({joke: updatedJoke})
        })
        .catch((err) => {
            res.json({message: 'Something went wrong', error: err})
        });
}

module.exports.deleteAnExistingJoke = (req,res) => {
    Joke.deleteOne( {_id: req.params.id })
    .then(result => {
        res.json( {result: result})
    })
    .catch((err) => {
        res.json({message:'Something went wrong', error:err})
    });
}