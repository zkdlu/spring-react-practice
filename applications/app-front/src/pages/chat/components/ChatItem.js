import { Component } from "react";
import './ChatItem.css'

class ChatItem extends Component {

    enterMessage(sender) {
        return (
            <div className="chat-item-enter">
                <div className="sender">
                    {sender} 님이 입장하셨습니다.
                </div>
            </div>
        );
    }

    talkMessage(sender, msg) {
        return (
            <div className="chat-item-talk">
                <div className="sender">
                    {sender}
                </div>
                <div className="msg">
                    {msg}
                </div>
            </div>
        );
    }

    render() {
        const { type, sender, msg } = this.props;

        if (type === 'ENTER') {
            return this.enterMessage(sender);
        }

        return this.talkMessage(sender, msg);
    }
}

export default ChatItem;