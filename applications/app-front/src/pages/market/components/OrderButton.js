import { Component } from "react";
import './OrderButton.css'

class OrderButton extends Component {
    render() {
        const { product, onClick } = this.props;

        console.log(product);

        return (
            <div className="order-button" onClick={onClick}>
                주문하기
            </div>
        )
    }
}

export default OrderButton;