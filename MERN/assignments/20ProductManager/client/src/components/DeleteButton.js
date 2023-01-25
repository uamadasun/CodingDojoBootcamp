import axios from 'axios'
const DeleteButton = (props) => {
    const { productId, successCallback } = props;
    
    const deleteProduct = e => {
        axios.delete('http://localhost:8000/product/delete/' + productId)
            .then(res=>{
                successCallback();
            })
    }
    
    return (
        <button onClick={deleteProduct}>
            Delete
        </button>
    )
}

export default DeleteButton;