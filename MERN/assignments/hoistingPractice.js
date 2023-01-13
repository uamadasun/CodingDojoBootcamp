//Assignment: Rewrite the code the way it would be seen by the interpreter and predict the output.

//1.
console.log(hello);                                   
var hello = 'world';                                 
//prediction
//line 4
//logs 'undefined'
//line 5

//2.
var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
//prediction
//line 11
//line 13
//log 'magnet'

//3.
var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);
//prediction
//line 23
//line 24
//log 'super cool'

//4
var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
//prediction
//line 36
//log 'chicken'
//line 39
//line 38
//log 'half-chicken'

//5
mean();
console.log(food);
var mean = function() {
    food = "chicken";
    console.log(food);
    var food = "fish";
    console.log(food);
}
console.log(food);
//prediction
//log 'undefined'
//line 54
//error? food not defined [correct answer: logged error, mean is not a function];

//6
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);

//prediction
//line 67
//log 'undefined'
//line 68
//line 70
//line 69
//log 'rock'
//log 'r&b'
//line 76
//log 'disco'

//7
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
    dojo = "seattle";
    console.log(dojo);
    var dojo = "burbank";
    console.log(dojo);
}
console.log(dojo);

//prediction
//line 90
//log 'san jose'
//line 93
//log 'seattle'
//log 'burbank'
//line 99
//log 'san jose'

//8
console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
    const dojo = {};
    dojo.name = name;
    dojo.students = students;
    if(dojo.students > 50){
        dojo.hiring = true;
    }
    else if(dojo.students <= 0){
        dojo = "closed for now";
    }
    return dojo;
}
//prediction
//line 113
//line 111
//log '{'name':Chicago, 'students':65, 'hiring':true}
//line 112
//error can't change dojo type?






