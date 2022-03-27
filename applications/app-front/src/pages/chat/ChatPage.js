import { Component } from "react";
import Modal from "react-modal/lib/components/Modal";
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import Form from "../../components/Form";
import ChatList from "./components/ChatList";
import ChatTempplate from './components/ChatTemplate'

class ChatPage extends Component {
    state = {
        client: null,
        input: '',
        chats: [],
        isOpen: true,
        sender: '',
    }

    connect = () => {
        const { sender } = this.state;
        const sock = new SockJS('http://localhost:8080/ws-stomp');
        const client = Stomp.over(sock);

        client.connect({}, () => {
            client.subscribe("/sub/chat", (message) => {
                const { chats } = this.state;
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
                sender,
            }));
        });

        this.setState({
            client: client
        });
    }

    handleSend = () => {
        const { input, client, sender } = this.state;

        client.send("/pub/chat", {}, JSON.stringify({
            type: 'TALK',
            sender,
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

    setModalIsOpen = (open) => {
        this.setState({
            isOpen: open
        })

        this.connect();
    }

    inputSender = (e) => {
        this.setState({
            sender: e.target.value
        })
    }

    render() {
        const { input, chats, isOpen, sender } = this.state;
        const {
            handleSend,
            handleChange,
            handleKeyPress,
            setModalIsOpen,
            inputSender } = this;

        return (
            <ChatTempplate form={(
                <Form msg='입력'
                    value={input}
                    onChange={handleChange}
                    onKeyPress={handleKeyPress}
                    onClick={handleSend} />
            )}>
                <Modal style={{
                    overlay: {
                        position: 'fixed',
                        top: 0,
                        left: 0,
                        right: 0,
                        bottom: 0,
                        backgroundColor: 'rgba(0, 0, 0, 0.75)'
                    },
                    content: {
                        borderRadius: '4px',
                        bottom: 'auto',
                        minHeight: '10rem',
                        left: '50%',
                        padding: '2rem',
                        position: 'fixed',
                        right: 'auto',
                        top: '50%',
                        transform: 'translate(-50%,-50%)',
                        minWidth: '20rem',
                        width: '80%',
                        maxWidth: '60rem'
                    }
                }}

                    isOpen={isOpen}>
                    <span>
                        이름
                    </span>
                    <Form msg='확인'
                        value={sender}
                        onChange={inputSender}
                        onClick={() => setModalIsOpen(false)} />
                </Modal>
                <ChatList chats={chats} />
            </ChatTempplate>
        )
    }
}

export default ChatPage;