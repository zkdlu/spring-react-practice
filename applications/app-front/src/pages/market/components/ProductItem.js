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
                        <img className="product-image" src="https://cdn.011st.com/11dims/resize/800x800/quality/75/11src/dl/22/8/9/6/3/0/9/fXdKt/4232896309_139161764_05.jpg" />
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