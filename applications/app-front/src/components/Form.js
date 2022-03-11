import './Form.css';

const Form = ({msg, value, onChange, onCreate, onKeyPress}) => {
    return (
        <div className="form">
          <input value={value} onChange={onChange} onKeyPress={onKeyPress}/>
          <div className="create-button" onClick={onCreate}>
            {msg || '추가'}
          </div>
        </div>
    );
}

export default Form;