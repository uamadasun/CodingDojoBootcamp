//7
function ReturnOddsArray1To255() {
    var newArray = []
    for (var i = 1; i < 256; i++) {
        if (i%2) {
            newArray.push(i)
        }
    }
    return newArray
}

ReturnOddsArray1To255()

//8
