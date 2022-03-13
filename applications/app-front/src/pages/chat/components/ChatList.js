import { Component } from "react";
import ChatItem from "./ChatItem";

class ChatList extends Component {
    render() {
        const { chats } = this.props;
        const chatList = chats.map(({ sender, type, data }, index) => (
            <ChatItem
                key={index}
                sender={sender}
                type={type}
                msg={data}
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