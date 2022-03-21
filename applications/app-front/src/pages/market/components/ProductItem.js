import { Component } from "react";
import { Link } from "react-router-dom";
import './ProductItem.css'

class ProductItem extends Component {
    render() {
        const { id, name, price, stock, image } = this.props;

        return (
            <Link to={`/market/${id}`}>
                <div className="product">
                    <div>
                        {name}
                    </div>
                    <section>
                        <img className="product-image" src={image} />
                    </section>
                    <section>
                        {price} 원
                    </section>
                </div>
            </Link>
        )
    }
}

export default ProductItem;