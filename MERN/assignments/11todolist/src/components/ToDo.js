import React, { useState } from 'react';

const ToDo = () => {
    const [task, setTask] = useState({});
    const [allTasks, setAllTasks] = useState(JSON.parse(localStorage.getItem('tasks')));
    // console.log("Local storage info: " + localStorage.getItem('tasks'));

    const createTask = (e) => {
        e.preventDefault();
        // console.log(task);
        setAllTasks([...allTasks, {title:task, completed:false}]);
        // console.log([...allTasks, {title:task, completed:false}]);
        localStorage.setItem('tasks', JSON.stringify([...allTasks, {title:task, completed:false}]));
        // console.log("local storage info: " + localStorage.getItem('tasks'))
        e.target.reset();
        
        
    }

    const completeTask = (e, idx) => { 
        let newAllTasks = allTasks.map((item, i) => {
            if(i=== idx) {
                return{...item, completed:e.target.checked}
            } else{
                return item
            }
        });
        // console.log(newAllTasks);
        setAllTasks(newAllTasks)
        localStorage.setItem('tasks', JSON.stringify(newAllTasks));
        // console.log("local storage updated info: " + localStorage.getItem('tasks'));
        
    }

    // const deleteTask = (item) => { 
    //     setAllTasks((allTasks) => allTasks.filter((currentTask) => currentTask.title !== item.title));
    // }
    const deleteTask = (item) => { 
        setAllTasks((allTasks) => allTasks.filter((currentTask) => currentTask.title !== item.title));
        localStorage.setItem('tasks', JSON.stringify(allTasks.filter((currentTask) => currentTask.title !== item.title)));
        // console.log(localStorage.getItem('tasks'));
    }

    return(
        <div className='container mt-5'>
            <form onSubmit={createTask} className="form">
                <div className='m-3'>
                    <input type ="text" onChange={(e) => setTask(e.target.value)}/>
                </div>
                <button className="btn btn-primary" type='submit'> Add Task</button>
                
            </form>

            <div className='m-5'>
                {allTasks.map ((item, idx) => 
                <div key={idx}>
                    <ul className="list-group ">
                        <li className="list-group-item row g-1">
                            <p style={item.completed ? {textDecoration: 'line-through'} : {fontWeight: 'normal'}}> { item.title } </p>
                            {/* <input type="checkbox" checked ={item.completed} onClick={e => setAllTasks([...allTasks, {title:item.title, completed:e.target.checked}])}/> */}
                            <input type="checkbox" checked ={item.completed} onClick={(e) => {completeTask(e, idx)}}/>
                            <button className="btn btn-danger" onClick={()=> deleteTask(item)}>Delete</button>
                        </li>
                    </ul>
                </div>
                    )}


                
            </div>

        </div>
    )
}



export default ToDo;