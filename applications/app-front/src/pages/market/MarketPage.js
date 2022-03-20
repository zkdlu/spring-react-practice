import { Component } from "react";
import api from "../../api";
import MarketTemplate from "./components/MarketTemplate";
import ProductList from "./components/ProductList";

class MarketPage extends Component {
    state = {
        products: []
    }

    async componentDidMount() {
        await this.fetchProducts();
    }

    async fetchProducts() {
        const fetchedProducts = await api.get('products');
        this.setState({
            products: [...fetchedProducts]
        })
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