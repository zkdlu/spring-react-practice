import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from '../../api'
import ProductDetailItem from "./components/ProductDetailItem";
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
        <ProductTemplate>
            <ProductDetailItem product={product} />
            <div>
                구매영역
            </div>
        </ProductTemplate>
    )
}

export default ProductPage;