//like bubble sort, but a little better.
//on first loop, searches for lowest value
//when finished, swaps lowest value for value at 0 index
//on second loop, searches for second lowest value, then
//swaps with value at 1 index
//continue this pattern until whole array is sorted

//JOHN'S SOLUTION
const selectionSort = (arr) =>{
    for (let i = 0; i < arr.length; i++) {
        let j = 0;
        while(i != j) {
            if (arr[i] < arr[j]) {
                let temp = arr[i];
                arr[i] = arr[j]
                arr[j] = temp
            }
            j++
        }
    }
    return arr;
}

//JACOB'S SOLUTION
const insertionSort = (arr) => {
    for (let i = 1; i < arr.length; i++) {
      let currentValue = arr[i];
      let j;
      for (j = i - 1; j >= 0 && arr[j] > currentValue; j--) {
        arr[j + 1] = arr[j];
      }
      arr[j + 1] = currentValue;
    }
    return arr;
  }

const testArr = [6, 4, 5, 2, 8, 14, 1, 3]
    



//