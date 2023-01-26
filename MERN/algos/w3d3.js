/**
 * Finds a list of people whose habits contain the given bad habit.
 * - Time O(?).
 * - Space O(?).
 * @typedef {Object} Person
 * @property {string} firstName
 * @property {string} lastName
 * @property {Array<string>} habits
 * @param {Array<Person>} persons
 * @param {string} badHabit
 * @returns {Array<Person>} The people that have the given bad habit.
 */
function santasNaughtyList(persons, badHabit) {
    let outArr = [];
    for (i = 0; i < persons.length; i++) {
        for (j = 0; j < persons[i].habits.length; j++) {
            if (badHabit === persons[i].habits[j]) {
                outArr.push(`${persons[i].firstName} ${persons[i].lastName}`);
                break;
            }
        }
    }
    return outArr;
}

console.log("Standard:");
console.log(santasNaughtyList(students, badHabit1));
console.log(santasNaughtyList(students, badHabit2));
console.log(santasNaughtyList(students, badHabit3));

/**
 * Finds a list of people whose habits contain the given bad habit.
 * - Time O(?).
 * - Space O(?).
 * @typedef {Object} Person
 * @property {string} firstName
 * @property {string} lastName
 * @property {Array<string>} habits
 * @param {Array<Person>} persons
 * @param {string} badHabit
 * @returns {Array<Person>} The people that have the given bad habit.
 */
function santasNaughtyListFunctional(persons, badHabit) {
    return persons.filter(person => { //O(n)
        return person.habits.includes(badHabit); //O(m) 
    }).map((person, i) => { //O(k)
        return `${person.firstName} ${person.lastName}`
    })
}
//Worst Case: O(n*m)+O(k)
//Best Case: O(n+m)+O(k)
//Technically less functional than the base function

console.log("Functional:");
console.log(santasNaughtyListFunctional(students, badHabit1));
console.log(santasNaughtyListFunctional(students, badHabit2));
console.log(santasNaughtyListFunctional(students, badHabit3));