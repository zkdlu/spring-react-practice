import './LottoTemplate.css'

const LottoTemplate = ({ form, children }) => {
    return (
        <main className="lotto-template">
            <div className="title">
                로또 번호
            </div>
            <section className="form-wrapper">
                {form}
            </section>
            <section className="lotto-wrapper">
                {children}
            </section>
        </main>
    )
}

export default LottoTemplate;