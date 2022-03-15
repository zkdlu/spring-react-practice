import { Component } from "react";
import ProductItem from "./ProductItem";

class ProductList extends Component {
    render() {
        const { products } = this.props;
        const productList = products.map(({ id, name, price, stock }) => (
            <ProductItem
                key={id}
                name={name}
                price={price}
                stock={stock}
            />
        ));

        return (
            <div>
                {productList}
            </div>
        )
    }
}

export default ProductList;