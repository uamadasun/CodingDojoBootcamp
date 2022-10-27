function reverseArr(arr) {
    for (var i = 0; i<arr.length/2; i++) {
        var temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    return arr;
}

testArr = [1,2,3,4,5]

console.log(reverseArr(testArr))