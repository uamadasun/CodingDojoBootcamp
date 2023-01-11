import PersonCard from './components/PersonCard';
// import Peeps from './components/Peeps';


function App() {

  
  return (
    <div className="App">

      <PersonCard people= {{ firstName: "Jane", lastName: "Doe", age: 45,hairColor: "Black",}}/>
      <PersonCard people= {{firstName: "John",lastName: "Smith",age: 88,hairColor: "Brown",}}/>
      <PersonCard people= {{firstName: "Millard", lastName: "Fillmore", age: 50,hairColor: "Brown",}}/>
      <PersonCard people= {{firstName: "Maria",lastName: "Smith", age: 62,hairColor: "Brown",}}/>

    </div>
  );
}

export default App;
