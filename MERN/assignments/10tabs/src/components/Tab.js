import React, { useState } from 'react';

const Tab = (props) => {
    const [currentTab, setCurrentTab] = useState("");
    // console.log("This is all tabs" + props.allTabs);
    const [content, setContent] = useState("");


    const onClickHandler = (e, item) => {
        // console.log(item.content);
        setCurrentTab(item)
        console.log(item);
        setContent(item.content);
        // props.getContent = item.content;

    }

    return(
        <div className = "container mt-4">

            <div className = "d-inline-flex align-content-middle">
                {props.allTabs.map((item,i) => 
                <div key={i}> 
                <button className={currentTab === item ? "btn btn-success m-3" : "btn btn-danger m-3"} 
                name={item} onClick={(e) => onClickHandler(e, item)}> {item.name} </button> </div>
                )}
            </div>
            <div className = "card">
                {content}
            </div>
            
        </div>
    )

//     return (
        

//         props.arr.map( (item, i) => { 
//         return (
//             <div>
//             <div key={i} className = "d-inline-flex align-content-middle">
//                 <button name={item} value={item.name} onClick={(e)=>onClickHandler(e, item)}> { item.name } </button>
//             </div>
//             {/* <div>this is where the box should go </div> */}
            
            
//             </div>
        
//     )})
//     // <div>this is where the box should go </div>
    
// );
            

    
}

export default Tab;