async function getCoderData() {
    const username = document.getElementById("getUsername").value;
    
    if (!username) {
        alert("Enter a username.");
        return;
    }

    const endpoint = new URL(`https://api.github.com/users/${ username }`)

    // if we had a tok to put in, we would do:
    //endpoint.searchParams.set("token", "YOUR_TOKEN_HERE");

    const response = await fetch(endpoint);

    //IF YOU REQUIRE AN AUTHORIZATION, THIS SECTION WILL LOOK LIKE THIS INSTEAD
    // const response = await fetch(endpoint, {
    //     headers: {
    //         "Authorization": "YOUR_TOKEN_HERE"
    //     }
    // });
    if (response.status === 404) {
        alert("Username not found.");
        return;
    }

    const data = await response.json();
    alert(`${data.login} has ${data.public_repos} public repos.`)
    console.log(data);

}