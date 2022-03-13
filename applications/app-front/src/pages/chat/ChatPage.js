import { Component } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import Form from "../../components/Form";
import ChatList from "./components/ChatList";
import ChatTempplate from './components/ChatTemplate'

class ChatPage extends Component {
    state = {
        client: null,
        input: '',
        chats: []
    }

    componentDidMount() {
        const sock = new SockJS('http://localhost:8080/ws-stomp');
        const client = Stomp.over(sock);

        client.connect({}, () => {
            client.subscribe("/sub/chat", (message) => {
                const {chats} = this.state;
                const body = JSON.parse(message.body);
                const chat = {
                    sender: body.sender,
                    type: body.type,
                    data: body.data
                }

                this.setState({
                    chats: [...chats, chat]
                })
            });

            client.send("/pub/chat", {}, JSON.stringify({
                type: 'ENTER',
                sender: 'sender1'
            }));
        });

        this.setState({
            client: client
        });
    }

    handleSend = () => {
        const { input, client } = this.state;

        client.send("/pub/chat", {}, JSON.stringify({
            type: 'TALK',
            sender: 'sender1',
            data: input
        }));

        this.setState({
            input: '',
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