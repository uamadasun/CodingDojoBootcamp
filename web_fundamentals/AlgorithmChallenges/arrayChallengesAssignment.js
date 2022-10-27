// 1. Always Hungry: Write a function that is given an array and each time the value is "food" it should console log "yummy". If "food" was not present in the array console log "I'm hungry" once.
function alwaysHungry(arr) {
    // your code here 
    var count = 0;
    for (var i=0;i<arr.length;i++) {
        if (arr[i]=="food") {
            count++;
            console.log("yummy")
        }
    }
    if (count==0){
        console.log("I'm hungry")
    }
}

// alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
// alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"




// 2. High Pass Filter: Given an array and a value cutoff, return a new array containing only the values larger than cutoff.
function highPass(arr, cutoff) {
    var filteredArr = [];
    // your code here
    for (var i=0;i<arr.length;i++) {
        if (arr[i] > cutoff) {
            filteredArr.push(arr[i])
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
// console.log(result); // we expect back [6, 8, 10, 9]




// 3. Better than average: Given an array of numbers return a count of how many of the numbers are larger than the average.
function betterThanAverage(arr) {
    var sum = 0;
    // calculate the average
    for (var i=0;i<arr.length;i++) {
        sum += arr[i]
    }
    avg = sum/arr.length

    var count = 0
    for (var i=0;i<arr.length;i++) {
        if (arr[i] >avg) {
            count++
        }
    }
    // count how many values are greated than the average
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
// console.log(result); // we expect back 4



//4. Array Reverse: Write a function that will reverse the values an array and return them.

function reverse(arr) {
    // your code here
    for (var i=0; i<= arr.length/2;i++) {
        var temporary = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temporary;
    }
    return arr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
// console.log(result); // we expect back ["e", "d", "c", "b", "a"]


//5. Fibonacci Array: Write a function that will return an array of Fibonacci numbers up to a given length n
function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from
    var fibArr = [0, 1];
    // your code here
    for (var i=1;fibArr.length<n;i++) {
        fibArr.push(fibArr[i]+fibArr[i-1])
    }
    return fibArr;
}

var result = fibonacciArray(10);
// console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]