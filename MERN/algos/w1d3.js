//combine two pre-sorted arrays into one sorted array
//return the newly combined array
//bonus challenge: combine in place into leftArr instead of a new array


//JACOB'S SOLUTION
const combine = (arr1, arr2) => {
    // create i and j to be two pointers for each array that are initially set to 0.
    let i = 0;
    let j = 0;
    let sortedArr = [];
    // will run as long as [i] is < the length of arr1 and j is < arr2
    // this makes sure that both are compared until one of them is fully merged.
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            sortedArr.push(arr1[i]);
            i++;
        } else {
            sortedArr.push(arr2[j]);
            j++;
        }
    }
    // add any remaining elements
    // this helps to account for any arrays that may have leftover items, i.e. one array is longer than the other.
    while (i < arr1.length) {
        sortedArr.push(arr1[i]);
        i++;
    }
    while (j < arr2.length) {
        sortedArr.push(arr2[j]);
        j++;
    }
    return sortedArr;
}

//FELIX'S SOLUTION
const combine = (leftArr, rightArr) => {
    let left = 0;
    let right = 0;
    let newArr = []
  
    while(left < leftArr.length && right < rightArr.length){
      if(leftArr[left] < rightArr[right] ){
        newArr.push(leftArr[left]);
        left++;
      }
      else{
        newArr.push(rightArr[right]);
        right++;
      }
    }
    while(right < rightArr.length){
      newArr.push(rightArr[right]);
      right++;
    }
    while (left < leftArr.length) {
      newArr.push(leftArr[left]);
      left++;
    }
    return newArr;
}


//MICHAEL'S SOLUTION
//use recursion to break up the array into halves and combine two sorted halves
const mergeSort = (arr) => {
    if(arr.length <=1) return arr;
    let half = Math.floor(arr.length/2);
    return combine(mergeSort(arr.slice(0, half)), mergeSort(arr.slice(half, arr.length)));
}




// should return [0,1,2,3,4,6,7,9,11]
// console.log(combine([1,2,7,9],[0,3,4,6,11]));

// should return [0,1]
// console.log(combine([1],[0]));
// should return [1,2,3,4,5,6,7]
// console.log(combine([1,2,3,4,5],[6,7]));
// // should return [78]
// console.log(combine([78],[]));
// // should return []
// console.log(combine([],[]));
// // should return [0,1,2,3,7,9,11,15,109]
// console.log(combine([3,9,10],[0,1,2,7,11,15,109]));