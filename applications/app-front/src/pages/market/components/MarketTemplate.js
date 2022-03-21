import './MarketTemplate.css'

const MarketTemplate = ({children}) => {
    return (
        <main className="market-template">
            <div className='market-title'>
                오늘의 딜
            </div>
            <section className="market-wrapper">
                {children}
            </section>
        </main>
    )
}

export default MarketTemplate;