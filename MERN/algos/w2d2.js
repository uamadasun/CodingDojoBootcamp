//Intersect two arrays to create an unsorted multiset
//return the new array of all the values that both arrays
//have in common

//[6,7,2,7,6,2], [2,7,2,1,2] returns [7,2,2]

const intersectUnsorted = (arrLeft,arrRight) => {
    let i = 0;
    let j = 0;
    let outArr = [];

    arrLeft.sort()
    arrRight.sort()

    while (i < arrLeft.length && j < arrRight.length){
        if (arrLeft[i] < arrRight[j]){
            i++;
        }
        if (arrRight[j] < arrLeft[i]){
            j++;
        }
        if (arrLeft[i] === arrRight[j]){
            outArr.push(arrLeft[i]);
            i++;
            j++;
        }
    }

    return outArr;

}

// console.log(intersectUnsorted([6,7,2,7,6,2], [2,7,2,1,2])); 
// console.log(intersectUnsorted([1,2,2,2,7],[2,2,6,6,7]));
// console.log(intersectUnsorted([1,5,9],[2,6,10]));

//return a new unsorted union multiset of two arrays
//essentially same as yesterday but your input is unsorted
//don't just sort the arrays, then do a union!

//[2,7,2,1,2], [6,7,2,7,6,2] returns [7,2,7,2,2,1,6,6]
//(or a different combination of the same numbers, since it's unsorted)

const unionUnsorted = (leftArr, rightArr) => {
    let newArr = []

    for(let i=0; i<leftArr.length; i++) {
        for (let j=0; j<rightArr.length; j++) {
            if(leftArr[i] === rightArr[j]) {
                newArr.push(leftArr[i])
                leftArr.splice(i, 1);
                rightArr.splice(j, 1);
                i--;
                j--;
            }
        }
    }
    return [...newArr, ...leftArr, ...rightArr]
}

console.log(unionUnsorted([2,7,2,1,2], [6,7,2,7,6,2])); 
console.log(unionUnsorted([2,1,10,7,9],[3,10,2,7,9,5,2]));
console.log(unionUnsorted([2,2,7,1,2],[2,2,6,7,6]));