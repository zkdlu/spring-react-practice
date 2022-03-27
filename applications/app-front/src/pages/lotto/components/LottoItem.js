import './LottoItem.css'

const LottoItem = ({ number }) => {
    return (
        <div className='lotto-item'>{number}</div>
    );
}

export default LottoItem;