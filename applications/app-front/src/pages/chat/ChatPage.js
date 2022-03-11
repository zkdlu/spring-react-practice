import { Component } from "react";
import Form from "../../components/Form";
import ChatList from "./components/ChatList";
import ChatTempplate from './components/ChatTemplate'

class ChatPage extends Component {
    state = {
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

    render() {
        const { chats } = this.state;

        return (
            <ChatTempplate form={(
                <Form msg='입력'/>
            )}>
                <ChatList chats={chats}/>
            </ChatTempplate>
        )
    }
}

export default ChatPage;