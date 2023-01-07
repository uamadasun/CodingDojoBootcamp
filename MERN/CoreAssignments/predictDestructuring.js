//For the following five blocks of code, predict the output. If a line of code will throw an error, state the error.

//1
// const cars = ['Tesla', 'Mercedes', 'Honda']
// const [ randomCar ] = cars
// const [ ,otherRandomCar ] = cars
// //Predict the output
// console.log(randomCar)
// console.log(otherRandomCar)

//<PREDICTION>
//log 'Tesla'
//log 'Mercedes'

//2
// const employee = {
//     name: 'Elon',
//     age: 47,
//     company: 'Tesla'
// }
// const { name: otherName } = employee;
// //Predict the output
// console.log(name);
// console.log(otherName);

//<PREDICTION>
//error; name is not defined

//3
// const person = {
//     name: 'Phil Smith',
//     age: 47,
//     height: '6 feet'
// }
// const password = '12345';
// const { password: hashedPassword } = person;  
// //Predict the output
// console.log(password);
// console.log(hashedPassword);

//<PREDICTION>
//log '12345
//log 'undefined'

//4
// const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
// const [,first] = numbers; //2
// const [,,,second] = numbers;//5
// const [,,,,,,,,third] = numbers;//2
// //Predict the output
// console.log(first == second);
// console.log(first == third);

//<PREDICTION>
//log 'false'
//log 'true'

//5
const lastTest = {
    key: 'value',
    secondKey: [1, 5, 1, 8, 3, 3]
}
const { key } = lastTest; //value
const { secondKey } = lastTest; //[1,5,1,8,3,3]
const [ ,willThisWork] = secondKey; //5
//Predict the output
console.log(key);
console.log(secondKey);
console.log(secondKey[0]);
console.log(willThisWork);

//<PREDICTION>
//log 'value'
//log [1,5,1,8,3,3]
//log 1
//log 5

