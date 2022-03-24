import { Component } from "react";
import OrderButton from "./OrderButton";
import './ProductOrder.css'

class ProductOrder extends Component {
    render() {
        const { product, onClick } = this.props;

        return (
            <div className="product-order">
                <div className="product-order-title">
                    {product.name}
                </div>
                <section className="product-order-info">
                    <span className="prodcut-order-discount">50%</span>
                    <span className="product-order-amount">
                        {product.price}원
                    </span>
                    <span className="product-order-price">
                        {product.price * 1.5}원
                    </span>
                </section>
                <section>
                    {product.stock}개 남음
                </section>
                <OrderButton onClick={onClick}/>
            </div>
        )
    }
}

export default ProductOrder;