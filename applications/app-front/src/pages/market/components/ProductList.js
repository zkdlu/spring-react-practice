import { Component } from "react";
import ProductItem from "./ProductItem";
import './ProductList.css'

class ProductList extends Component {
    render() {
        const { products } = this.props;
        const productList = products.map(({ id, name, price, stock }) => (
            <ProductItem
                key={id}
                name={name}
                price={price}
                stock={stock}
                id={id}
            />
        ));

        return (
            <div className="product-list">
                {productList}
            </div>
        )
    }
}

export default ProductList;