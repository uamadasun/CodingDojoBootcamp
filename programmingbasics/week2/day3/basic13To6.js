//1.
function Print1To255() {
    for (var i = 1; i < 256; i++) {
        console.log(i)
    }
}

//2.
function PrintOdds1To255() {
    var i = 1
    while (i < 256) {
        if (i % 2 != 0) {
            console.log(i)
        }
        i++
    }
}

//3. 
function PrintIntsAndSum0To255() {
    var sum = 0
    for (var i = 0; i < 256; i++) {
        console.log(i)
        sum += i
        console.log("Sum so far = ", sum)
    }
}

//4.
function PrintArrayVals(arr) {
    var i = 0
    while (i < arr.length) {
        console.log(arr[i])
        i++
    }
}

//5.
function PrintMaxOfArray(arr) {
    var maximum = arr[0]
    var i = 0
    while (i < arr.length) {
        if (arr[i] > maximum) {
            maximum = arr[i]
        } 

        i++
    }
    console.log(maximum)
}



PrintMaxOfArray([1,2,-3])