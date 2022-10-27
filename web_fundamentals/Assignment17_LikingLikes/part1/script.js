var likesElement = document.querySelector("h2");
var count = 3;

function addLikes(element) {
    count++;
    likesElement.innerText = count + " like(s)"
}