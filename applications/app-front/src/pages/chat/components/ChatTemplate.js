import './ChatTemplate.css'

const ChatTemplate = ({form, children}) => {
    return (
        <main className="chat-template">
            <div className="title">
                채팅
            </div>
            <section className="chat-wrapper">
                {children}
            </section>
            <section className="form-wrapper">
                {form}
            </section>
        </main>
    )
}

export default ChatTemplate;