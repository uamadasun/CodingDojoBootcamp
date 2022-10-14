function greet(name, timeOfDay) {
    if (name != "Count Dooku") {
        if (timeOfDay == "Morning") {
            return("Good morning, "+ name+ "!")

        } else if (timeOfDay == "Afternoon") {
            return ("Good afternoon, "+ name + "!")
        } else {
            return("Good evening, "+ name+ "!")
        }
    } else {
        return("I'm coming for you, Dooku!")
    }

}

console.log(greet("Count Dooku", "Evening"))