import './Form.css';

const Form = ({msg, value, onChange, onClick, onKeyPress}) => {
    return (
        <div className="form">
          <input value={value} onChange={onChange} onKeyPress={onKeyPress}/>
          <div className="create-button" onClick={onClick}>
            {msg || '추가'}
          </div>
        </div>
    );
}

export default Form;