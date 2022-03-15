import { Component } from "react";
import MarketTemplate from "./components/MarketTemplate";
import ProductList from "./components/ProductList";

class MarketPage extends Component {
    state = {
        products: [
            {
                id: 1,
                name: 'product-name',
                price: 1000,
                stock: 10
            }
        ]

    }

    render() {
        const { products } = this.state;
        return (
            <MarketTemplate>
                <ProductList products={products}/>
            </MarketTemplate>
        )
    }
}

export default MarketPage;