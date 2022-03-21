import { Component } from "react";
import './ProductDetailItem.css'

class ProductDetailItem extends Component {
    render() {
        const { product } = this.props;
        return (
            <div className="product-detail">
                <div className="product-detail-name">
                    {product.name}
                </div>
                <img className="product-detail-image"
                    src="https://cdn.011st.com/11dims/resize/640x640/quality/75/11src/dl/22/1/6/2/1/5/2/YvAQE/3736162152_139127350_05.jpg" />
                <div className="product-detail-info">
                    <section>
                        ⭐⭐⭐⭐⭐
                    </section>
                    <section>
                        리뷰 0개
                    </section>
                    <section>
                        재고 {product.stock}개
                    </section>
                </div>
            </div>
        )
    }
}

export default ProductDetailItem;