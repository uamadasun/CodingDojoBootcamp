// function evenOdd(arr) {
//     var count = 0
//     var evens = 0
//     var odds = 0

//     while (count < arr.length) {
//         if (arr[count] % 2 == 0) {
//             evens++
//             odds = 0
//             if (evens == 3) {
//                 console.log("Even more so")
//                 evens = 0
//             }
            
//         }
//         else if (arr[count] % 2 != 0) {
//             odds++
//             evens = 0
//             if (odds == 3) {
//                 console.log("That's odd")
//                 odds = 0
//             }
//         }

//         count++
//     }
// }

// tester = [2,3,4,5,3,2,4,8,7,6,43,4323]
// evenOdd(tester)

function evenOdd(arr) {
    var evens = 0
    var odds = 0
    for (var i=0; i < arr.length; i++) {
        if (arr[i] % 2 == 0) {
            evens++
            odds = 0
            if (evens == 3) {
                console.log("Even more so")
                evens = 0
            }
        }
        else if (arr[i] %2 != 0) {
            odds++
            evens = 0
            if (odds == 3) {
                console.log("That's odd")
                odds = 0
            }

        }
    }
}
tester = [1,1,1,3,3,3]
evenOdd(tester)
