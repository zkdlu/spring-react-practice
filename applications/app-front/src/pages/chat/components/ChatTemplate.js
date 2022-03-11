import { useEffect, useRef } from 'react';
import './ChatTemplate.css'

const ChatTemplate = ({form, children}) => {
    const divRef = useRef(null);

    useEffect(() => {
        divRef.current.scrollIntoView(false);
    });

    return (
        <main className="chat-template">
            <div className="title-area">
                채팅
            </div>
            <div className='chat-area' >
                <section className="chat-wrapper" ref={divRef}>
                    {children}
                </section>
            </div>
            <section className="form-wrapper">
                {form}
            </section>
        </main>
    )
}

export default ChatTemplate;