import { Component } from "react";
import Button from "../../../components/Button";
import './OrderButton.css'

class OrderButton extends Component {
    render() {
        const { product, onClick } = this.props;

        return (
            <Button msg='주문하기' onClick={() => onClick(product)}/>
        )
    }
}

export default OrderButton;