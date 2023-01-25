import axios from 'axios';
import React, { useEffect, useState } from 'react'
// import AuthorForm from '../components/AuthorForm';
import AuthorList from '../components/AuthorList';
import {Link} from 'react-router-dom'

const Main = () => {
    const [authors, setAuthors] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors')
            .then(res => {
                setAuthors(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = authorId => {
        setAuthors(authors.filter(author => author._id !== authorId));
    }
    
    
    return(
        <div>
            <h3>Favorite Authors</h3>
            <Link to="/author/create"> Add an author </Link>
            
            <h4>We have quotes by:</h4>
            <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">Author</th>
                            <th scope="col">Actions Available</th>
                        </tr>
                    </thead>
            </table>
            {loaded && <AuthorList authors = {authors} removeFromDom={removeFromDom}/>}
        </div>
    )
}
export default Main;