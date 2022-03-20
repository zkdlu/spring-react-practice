import { useEffect } from "react";
import { useParams } from "react-router-dom";
import api from '../../api'

async function fetchProduct(id) {
    const product = await api.get(`products/${id}`);

    console.log(product);
}

const ProductPage = () => {
    const { id } = useParams();
    
    useEffect(async () => {
        await fetchProduct(id);
    }, []);
    

    return (
        <div>
            product
        </div>
    )
}

export default ProductPage;