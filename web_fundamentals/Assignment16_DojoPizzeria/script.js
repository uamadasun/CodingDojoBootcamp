function pizzaOven(crustType, sauceType, cheeses, toppings) {
    pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings = toppings;
    return pizza;
}

var firstPizza = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"])
var secondPizza = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"])
var thirdPizza = pizzaOven("thin", "combination", ['parmesan'], ['pepperoni', 'ham', 'sausage'])
var fourthPizza = pizzaOven("stuffed crust", 'no sauce', 'mozarella', ['pineapples', 'ham', 'mushrooms'])
