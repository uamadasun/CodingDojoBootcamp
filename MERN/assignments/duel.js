class Card {
    constructor (name, cost) {
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card {
    constructor(name, cost, power, resilience) {
        super(name, cost);
        this.power = power;
        this.resilience = resilience;
    }

    attack(target) {
        target.resilience -= this.power;
    }
}

class Effect extends Card {
    constructor(name, cost, text, stat, magnitude) {
        super(name, cost);
        this.text = text;
        this.stat = stat;
        this.magnitude = magnitude;
    }

    play(target) {
        if(target instanceof Unit) {
            target[this.stat] += this.magnitude;
        } else {
            throw new Error("Target must be a unit! Try again.");
        }
    
}
}
//1
const redNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const hardAlgo = new Effect("Hard Algorithm", 2, "increase target's resilience by 3", "resilience", 3);
hardAlgo.play(redNinja);

//2
const blackNinja = new Unit("Black Belt Ninja", 4, 5, 4);
// console.log(redNinja.power);
const unPromise = new Effect("Unhandled Promise Rejection", 1, "reduce target's resilience by 2", "resilience", -2);
unPromise.play(redNinja);

//3
const pairPro = new Effect("Pair Programming", 3, "increase target's power by 2", "power", 2);
pairPro.play(redNinja);
// console.log("before attack:" + blackNinja.resilience);
redNinja.attack(blackNinja);
// console.log("after attack:" + blackNinja.resilience);
