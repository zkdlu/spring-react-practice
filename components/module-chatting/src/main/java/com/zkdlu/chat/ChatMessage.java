package com.zkdlu.chat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChatMessage {
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type;
    private String sender;
    private String data;
}
