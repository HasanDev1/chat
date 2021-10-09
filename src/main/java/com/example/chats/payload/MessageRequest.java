package com.example.chats.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageRequest {
    private String text;
    private UUID userId;
    private UUID chatId;
}
