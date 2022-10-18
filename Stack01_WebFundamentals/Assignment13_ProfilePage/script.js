var targetElement = document.querySelector("#fullName")

function changeName(element) {
    targetElement.innerText = "Uchenna Amadasun"
}


var personOne = document.querySelector(".person1");
var counter = 2;
var numToChange = document.querySelector(".button2")
function remove1(element) {
    personOne.remove();
    counter--;
    numToChange.innerText = counter;
}

var personTwo = document.querySelector(".person2")
function remove2(element) {
    personTwo.remove()
    counter--;
    numToChange.innerText = counter;
}

var currentFriendCount = 418
var addFriendCount = document.querySelector("#friendCount")
function removeAndAdd1(element) {
    personOne.remove();
    counter--
    currentFriendCount++;
    addFriendCount.innerText = currentFriendCount;
    numToChange.innerText = counter;

}

function removeAndAdd2(element) {
    personTwo.remove();
    counter--
    currentFriendCount++;
    addFriendCount.innerText = currentFriendCount;
    numToChange.innerText = counter;
}