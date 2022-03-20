import { Component } from "react";
import { Link } from "react-router-dom";
import './ProductItem.css'

class ProductItem extends Component {
    render() {
        const { id, name, price, stock } = this.props;

        return (
            <Link to={`/market/${id}`}>
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
            </Link>
        )
    }
}

export default ProductItem;