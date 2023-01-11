import PersonCard from './components/PersonCard';


function App() {

  
  return (
    <div className="App">

      <PersonCard person= {{ firstName: "Jane", lastName: "Doe", age: 45,hairColor: "Black",}}/>
      <PersonCard person= {{firstName: "John",lastName: "Smith",age: 88,hairColor: "Brown",}}/>
      <PersonCard person= {{firstName: "Millard", lastName: "Fillmore", age: 50,hairColor: "Brown",}}/>
      <PersonCard person= {{firstName: "Maria",lastName: "Smith", age: 62,hairColor: "Brown",}}/>

    </div>
  );
}

export default App;
