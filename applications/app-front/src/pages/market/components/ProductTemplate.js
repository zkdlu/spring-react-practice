import './ProductTemplate.css'

const ProductTemplate = ({children}) => {
    return (
        <main className="product-template">
            <div className='product-title'>
                상품상세
            </div>
            <section className="product-wrapper">
                {children}
            </section>
        </main>
    )
}

export default ProductTemplate;