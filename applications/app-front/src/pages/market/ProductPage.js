import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from '../../api'
import ProductTemplate from "./components/ProductTemplate";

async function fetchProduct(id) {
    const product = await api.get(`products/${id}`);
    return product;
}

const ProductPage = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(0);

    useEffect(async () => {
        const response = await fetchProduct(id);
        setProduct(response);
    }, []);

    return (
        <ProductTemplate product={product}>
            <img className="product-image" src="https://cdn.011st.com/11dims/resize/640x640/quality/75/11src/dl/22/1/6/2/1/5/2/YvAQE/3736162152_139127350_05.jpg" />
        </ProductTemplate>
    )
}

export default ProductPage;