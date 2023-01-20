/* 
    You are given a list of integers. Find all the consecutive sets of 
    integers that adds up to the sum passed in as one of the inputs.
*/
const findConsecutiveSums = (nums, targetSum) => {
    let arr = [];
    let sum = 0;
    for(let i=0; i<nums.length; i++) {
        sum += nums[i];
        for(let j=i+1; j<nums.length; j++) {
            sum += nums[j];
            if (sum > targetSum) {
                sum = 0;
                break;
            } 
            if (sum === targetSum) {
                arr.push(nums.slice(i, j +1));
            }
        }
    }
    return arr;

}

const nums1 = [2, 5, 3, 6, 7, 23, 12];
const sum1 = 16;
console.log(findConsecutiveSums(nums1,sum1));
// const expected1 = [
//   [2, 5, 3, 6],
//   [3, 6, 7],
// ];

const nums2 = [];
const sum2 = 5;
console.log(findConsecutiveSums(nums2,sum2));
// const expected2 = [];

const nums3 = [10, 15, 20, 35, 30];
const sum3 = 5;
console.log(findConsecutiveSums(nums3,sum3));
// const expected3 = [];

// Bonus:
const nums4 = [2, 5, 3, 6, 7, 0, 0, 23, 12];
const sum4 = 16;
console.log(findConsecutiveSums(nums4,sum4));
// const expected4 = [
//   [2, 5, 3, 6],
//   [3, 6, 7],
//   [3, 6, 7, 0],
//   [3, 6, 7, 0, 0],
// ];