import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import api from '../../api'
import ProductDetailItem from "./components/ProductDetailItem";
import ProductOrder from "./components/ProductOrder";
import ProductTemplate from "./components/ProductTemplate";

const ProductPage = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(0);
    const navigate = useNavigate();

    useEffect(async () => {
        const response = await fetchProduct(id);
        setProduct(response);
    }, []);

    async function fetchProduct(id) {
        const product = await api.get(`products/${id}`);
        return product;
    }

    async function handleOrder(product) {
        try {
            const response = await api.post(`order/${product.id}`);
            console.log(response);        
            navigate(`/payment/${response.data.orderId}`);
        } catch (e) {
            console.error(e);
        }
    }

    return (
        <ProductTemplate>
            <ProductDetailItem product={product} />
            <ProductOrder product={product} onClick={handleOrder} />
        </ProductTemplate>
    )
}

export default ProductPage;