import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Tab from "./components/Tab";
import React, { useState } from 'react';

//ask about bonuses
function App() {


  const tabObj = [{name:"Tab 1", content: "Tab 1 Content"}, {name:"Tab 2", content: "Tab 2 Content"}, {name:"Tab 3", content: "Tab 3 Content"}]

  // const tab1 = {name:"Tab 1", content: "Tab 1 Content"};
  // const tab2 = {name:"Tab 2", content: "Tab 2 Content"};
  // const tab3 = {name:"Tab 3", content: "Tab 3 Content"};
  // const [currentContent, setCurrentContent] = useState("");
  
  const [allTabs, setAllTabs] = useState(tabObj);
  const [currentTab, setCurrentTab] = useState(0);
  // const getContent = (content) => {
  //   console.log("content from app.js" + content)
  //   setCurrentContent(content);
  // }
  return (

    <div className="App">
      {/* <Tab arr={[tab1, tab2, tab3]} getContent = { getContent }/> */}
      <Tab allTabs={allTabs} />
      

      
    </div>

  );
}

export default App;
