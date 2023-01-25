import React from 'react'
import { Link } from 'react-router-dom';
// import DeleteButton from './DeleteButton';
import axios from 'axios';
    
const AuthorList = (props) => {
    // const {removeFromDom} = props;
    const {authors, removeFromDom} = props;
    console.log(authors)

    const deleteAuthor = (authorId) => {
        axios.delete('http://localhost:8000/api/author/'+ authorId)
        .then(res => {
            removeFromDom(authorId)
        })
        .catch(err => console.log(err));
    }


    return (
        <div>
            {authors.map( (author, i) =>
            <div key={i} className='mt-5 d-flex justify-content-around'>

                <table className="table table-hover">
                    <tbody>
                        <tr>
                            <td>{author.name}</td>
                            <td>
                                <Link to={`/author/edit/${author._id}`}> 
                                    <button className="btn btn-outline-warning"> 
                                        Edit 
                                    </button> 
                                </Link>
                                
                                    <button className="btn btn-outline-danger" onClick={ (e) => {deleteAuthor(author._id)}}> 
                                        Delete 
                                    </button> 
                            </td>
                        
                        </tr>
                    </tbody>
                </table>
            </div>
            )}
        </div>
    )
}
    
export default AuthorList;