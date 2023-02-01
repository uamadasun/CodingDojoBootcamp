/* 
  Given two strings S and T containing only lowercase letters and "#" characters,
  return if they are equal when both are typed into empty text editors.
  # character means a backspace character.
  i.e., after processing the backspaces, are the two strings equal?
  Bonus: solve in O(n) time
*/

const S1 = "ab#c";
const T1 = "ad#c";
const expected1 = true;
// Explanation: Both S and T become "ac"

const S2 = "ab##";
const T2 = "c#d#";
const expected2 = true;
// Explanation: Both S and T become ""

const S3 = "a##c";
const T3 = "#a#c";
const expected3 = true;
// Explanation: Both S and T become "c"

const S4 = "a#c";
const T4 = "b";
const expected4 = false;
// Explanation: S becomes "c" while T becomes "b".

/**
 * Determines if the given strings are equal after the backspace characters
 * "#" are processed.
 * - Time: O(?).
 * - Space: O(?).
 * @param {string} S
 * @param {string} T
 * @returns {boolean} Whether the given strings are equal after backspaces
 *    have been processed.
 */
function backspaceStringCompare(S, T) {
    let sArr = [];
    let tArr = [];
    let referenceString;
    if(S.length >= T.length) {
        referenceString = S.length;
    } else{
        referenceString = T.length;
    }

    for(let i=0; i<referenceString; i++){
        if (S[i] !== "#") {
            sArr.push(S[i])
        } else{
            if(sArr.length >= 1){
                sArr.pop()
            }
        }
        if (T[i] !== "#") {
            tArr.push(T[i])
        } else {
            if (tArr. length >=1){
                tArr.pop()
            }
        }
    }

    return sArr.toString() === tArr.toString();
    
 }

//  console.log(backspaceStringCompare(S1, T1));
//  console.log(backspaceStringCompare(S2, T2));
//  console.log(backspaceStringCompare(S3, T3));
//  console.log(backspaceStringCompare(S4, T4));



// =======================================================================================================

/* 
This was extracted from a react interview challenge. The items were to be
displayed in category groups.
Given an array of objects that contain a category key,
return a hash table to group the objects by their category.
Make the grouping case-insensitive.
*/

const objects = [
    {
        name: "Baby Yoda",
        category: "cute",
    },
    {
        name: "Cricket Protein",
        category: "food",
    },
    {
        name: "Shibe",
        category: "Cute",
    },
    {
        name: "Ancient India",
        category: "Cradle of Civilization",
    },
    {
        name: "Wasp Crackers",
        category: "Food",
    },
    {
        name: "The Fertile Crescent",
        category: "Cradle of Civilization",
    },
];

const expected = {
    cute: [
        {
            name: "Baby Yoda",
            category: "cute",
        },
        {
            name: "Shibe",
            category: "Cute",
        },
    ],
    food: [
        {
            name: "Cricket Protein",
            category: "food",
        },
        {
            name: "Wasp Crackers",
            category: "Food",
        },
    ],
    "cradle of civilization": [
        {
            name: "Ancient India",
            category: "Cradle of Civilization",
        },
        {
            name: "The Fertile Crescent",
            category: "Cradle of Civilization",
        },
    ],
};

/**
 * Creates a hash table of case-insensitive categories mapped to the items
 * belonging to that category.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<Object>} items
 * @param {string} items.category
 * @returns {Object<string, Array<Object>>} The hash category hash table with
 *    string keys and array of objects as values.
 */
function groupObjects(items) {
    let hashMap = {};

    for (let item in items) {
        let actualItem = items[item];
        let actualItemCategory = items[item].category.toLowerCase();
        if(hashMap[actualItemCategory]) {
            let categoryArray = hashMap[actualItemCategory]

            hashMap[items[item].category.toLowerCase()] = [...categoryArray, items[item]]
        } else {
            hashMap[items[item].category.toLowerCase()] = [items[item]]
        }
    }

    return hashMap;
 }

 console.log(groupObjects(objects));