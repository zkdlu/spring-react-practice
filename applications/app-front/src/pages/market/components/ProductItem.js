import { Component } from "react";

class ProductItem extends Component {
    render() {
        const { id, name, price, stock } = this.props;

        return (
            <div>
                {name}, {price}, {stock}
            </div>
        )
    }
}

export default ProductItem;