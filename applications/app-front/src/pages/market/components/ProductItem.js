import { Component } from "react";
import './ProductItem.css'

class ProductItem extends Component {
    render() {
        const { id, name, price, stock } = this.props;

        return (
            <div className="product">
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