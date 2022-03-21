import { Component } from "react";
import ProductItem from "./ProductItem";
import './ProductList.css'

class ProductList extends Component {
    state = {
        imageTable: [
            "https://cdn.011st.com/11dims/resize/800x800/quality/75/11src/dl/22/9/6/9/5/1/8/YqZCO/3821969518_139168930_05.jpg",
            "https://cdn.011st.com/11dims/resize/800x800/quality/75/11src/dl/22/8/9/6/3/0/9/fXdKt/4232896309_139161764_05.jpg",
            "https://cdn.011st.com/11dims/resize/640x640/quality/75/11src/dl/22/1/6/2/1/5/2/YvAQE/3736162152_139127350_05.jpg",
            "https://cdn.011st.com/11dims/resize/640x640/quality/75/11src/dl/22/2/3/4/3/1/1/rBbIU/3898234311_139168879_05.png"
        ]
    }

    render() {
        const { products } = this.props;
        const { imageTable } = this.state;

        const productList = products.map(({ id, name, price, stock }) => (
            <ProductItem
                key={id}
                name={name}
                price={price}
                stock={stock}
                id={id}
                image={imageTable[id % imageTable.length]}
            />
        ));

        return (
            <div className="product-list">
                {productList}
            </div>
        )
    }
}

export default ProductList;