import './MarketTemplate.css'

const MarketTemplate = ({children}) => {
    return (
        <main className="market-template">
            <section className="market-wrapper">
                {children}
            </section>
        </main>
    )
}

export default MarketTemplate;