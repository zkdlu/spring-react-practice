import { Component } from "react";
import './ProductItem.css'

class ProductItem extends Component {
    goToProductPage = () => {
        const { id } = this.props;
        window.location.href = `/market/${id}`;
    }

    render() {
        const { name, price, stock } = this.props;
        const {
            goToProductPage
        } = this;

        return (
            <div className="product" onClick={goToProductPage}>
                <div>
                    {name}
                </div>
                <section>
                    {price}
                </section>
                <section>
                    {stock}
                </section>
            </div>
        )
    }
}

export default ProductItem;