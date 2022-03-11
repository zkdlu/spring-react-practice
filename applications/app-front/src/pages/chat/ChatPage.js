import { Component } from "react";
import Form from "../../components/Form";
import ChatList from "./components/ChatList";
import ChatTempplate from './components/ChatTemplate'

class ChatPage extends Component {
    state = {
        input: '',
        chats: [
            {
                sender: 'sender1',
                type: 'talk',
                msg: 'msg1',
            },
            {
                sender: 'sender2',
                type: 'enter',
                msg: '',
            }
        ]
    }

    handleSend = () => {
        const { input, chats } = this.state;

        const chat = {
            sender: 'sender1',
            type: 'talk',
            msg: input
        }

        this.setState({
            input: '',
            chats: [...chats, chat]
        })
    }

    handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.handleSend();
        }
    }

    handleChange = (e) => {
        this.setState({
            input: e.target.value
        })
    }

    render() {
        const { input, chats } = this.state;
        const { 
            handleSend,
            handleChange,
            handleKeyPress } = this;

        return (
            <ChatTempplate form={(
                <Form msg='입력'
                    value={input}
                    onChange={handleChange}
                    onKeyPress={handleKeyPress}
                    onClick={handleSend} />
            )}>
                <ChatList chats={chats} />
            </ChatTempplate>
        )
    }
}

export default ChatPage;