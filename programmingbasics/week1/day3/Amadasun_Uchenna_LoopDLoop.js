//1. we're repeating the action of giving candy based on miles and there is a stop condition
//2. when the runner starts running is the starting point
//3. the loop should stop when the runner reaches mile 6
//4. we'll add the conditional into the for loop
//5. the miles the runner has run is what's incremented
//6. current mile the runner is at (which should start at zero), while mile is less than or equal to 6, and the miles should increment by 1, also the amount of candy given should be incremented every time it's given.

// candy_given = 0
// for (var mile = 0; mile <= 6; mile ++) {
//    if (mile > 0 && mile%2 == 0) {
//        candy_given += 1
//     }

// }

var candy_given = 0
var miles_per_hour = 6.5

for (var mile = 0; mile <= 6; mile ++) {
    if (miles_per_hour >= 5.5 && mile%2==0) {
        candy_given += 1
    }
}
console.log(candy_given)


var arr = [1,2,3,4,5,6,7]
console.table(arr)