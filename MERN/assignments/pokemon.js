const pokemon = Object.freeze([
        { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
        { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
        { "id": 9,   "name": "Blastoise",  "types": ["water"] },
        { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
        { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
        { "id": 23,  "name": "Ekans",      "types": ["poison"] },
        { "id": 24,  "name": "Arbok",      "types": ["poison"] },
        { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
        { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
        { "id": 52,  "name": "Meowth",     "types": ["normal"] },
        { "id": 63,  "name": "Abra",       "types": ["psychic"] },
        { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
        { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
        { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
        { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
        { "id": 98,  "name": "Krabby",     "types": ["water"] },
        { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
        { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
        { "id": 133, "name": "Eevee",      "types": ["normal"] },
        { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
        { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
        { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
        { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
    ]);

//an array of pokémon objects where the id is evenly divisible by 3
let id3 = pokemon.filter(item => item['id']%3 === 0);
// console.log(id3);

//an array of pokémon objects that are "fire" type
let fireTypes = pokemon.filter(item => item.types.includes("fire"));
// console.log(fireTypes);

//an array of pokémon objects that have more than one type
let moreThanOne = pokemon.filter(item => item['types'].length > 1) 
// console.log(moreThanOne);

//an array with just the names of the pokémon
let pokeNames = pokemon.map(item => item.name);
// console.log(pokeNames);

// /an array with just the names of pokémon with an id greater than 99
let nameID99 = pokemon.filter(item => item.id > 99).map(item => item.name);
// console.log(nameID99);

// an array with just the names of the pokémon whose only type is poison
let poison = pokemon.filter(item => item.types.length ==1 && item.types.includes("poison"));
// console.log(poison);

//an array containing just the first type of all the pokémon whose second type is "flying"
let flying = pokemon.filter(item => item.types[1] == 'flying').map(item => item.types[0]);
// console.log(flying);

//a count of the number of pokémon that are "normal" type
let counter = pokemon.filter(item => item.types.includes("normal")).length;
console.log(counter);
