import React, { useState } from 'react';

const ToDo = () => {
    const [task, setTask] = useState({});
    const initialState = localStorage.getItem('tasks') === null ? [] : JSON.parse(localStorage.getItem('tasks'));
    const [allTasks, setAllTasks] = useState(initialState);
    //change filter and maps
    //create a task component and call it here instead of rendering them on this page.
    const createTask = (e) => {
        e.preventDefault();
        setAllTasks([...allTasks, {title:task, completed:false}]);
        localStorage.setItem('tasks', JSON.stringify([...allTasks, {title:task, completed:false}]));
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
        setAllTasks(newAllTasks)
        localStorage.setItem('tasks', JSON.stringify(newAllTasks));
        ///better way: allTasks[idx].completed = !allTasks[idk].completed;
        //then update the states
        
    }

    const deleteTask = (item) => { 
        setAllTasks((allTasks) => allTasks.filter((currentTask) => currentTask.title !== item.title));
        localStorage.setItem('tasks', JSON.stringify(allTasks.filter((currentTask) => currentTask.title !== item.title)));
        //can use splice and update the states using the spliced allTasks
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
                {   allTasks.map ((item, idx) => 
                <div key={idx}>
                    <ul className="list-group ">
                        <li className="list-group-item row g-1">
                            <p style={item.completed ? {textDecoration: 'line-through'} : {fontWeight: 'normal'}}> { item.title } </p>
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