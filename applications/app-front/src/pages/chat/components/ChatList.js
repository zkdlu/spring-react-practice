import { Component } from "react";
import ChatItem from "./ChatItem";

class ChatList extends Component {
    render() {
        const { chats } = this.props;
        const chatList = chats.map(({ sender, type, msg }, index) => (
            <ChatItem
                key={index}
                sender={sender}
                type={type}
                msg={msg}
            />)
        )

        return (
            <div>
                {chatList}
            </div>
        )
    }
}

export default ChatList;