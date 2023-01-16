import PersonCard from './components/PersonCard';
// import Peeps from './components/Peeps';


function App() {
  // ANOTHER WAY
  // const cards = [
  //   {last_name:"Doe", first_name:"Jane", age:45, hair_color:"black"},
  //   {last_name:"Smith", first_name:"John", age:88, hair_color:"brown"},
  //   {last_name:"Fillmore", first_name:"Millard", age:50, hair_color:"brown"},
  //   {last_name:"Smith", first_name:"Maria", age:62, hair_color:"brown"}
  // ];

  
  return (
    <div className="App">
      <PersonCard people= {
        [{
            firstName: "Jane",
            lastName: "Doe",
            age: 45,
            hairColor: "Black",
        }, {
            firstName: "John",
            lastName: "Smith",
            age: 88,
            hairColor: "Brown",
        }, {
            firstName: "Millard",
            lastName: "Fillmore",
            age: 50,
            hairColor: "Brown",
        }, {
            firstName: "Maria",
            lastName: "Smith",
            age: 62,
            hairColor: "Brown",
        }]
      } /> 
      {/* ANOTHER WAY */}
      {/* {cards.map((p, i)=> <div key={i}><Peeps person={p}/></div>)} */}

    </div>
  );
}

export default App;
