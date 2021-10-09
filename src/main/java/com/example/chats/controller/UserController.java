package com.example.chats.controller;

import com.example.chats.entity.Chat;
import com.example.chats.payload.*;
import com.example.chats.service.ChatService;
import com.example.chats.service.MessageService;
import com.example.chats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ChatService chatService;
    private final MessageService messageService;

    @PostMapping("users/add")
    public ResponseEntity addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @PostMapping("chats/add")
    public ResponseEntity createChat(@RequestBody ChatRequest chatRequest){
        return chatService.createChat(chatRequest);
    }

    @PostMapping("messages/add")
    public ResponseEntity createMessage(@RequestBody MessageRequest messageRequest){
        return messageService.createMessage(messageRequest);
    }

    @GetMapping("chats/get")
    public List<Chat> getAllChatByUserId(@RequestBody GetChatByUserIdRequest getChatByUserIdRequest){
        return chatService.getAllChatByUser(getChatByUserIdRequest);
    }

    @GetMapping("messages/get")
    public ResponseEntity getAllMessageByChatId(@RequestBody MessagesByChatRequest messagesByChatRequest){
        return messageService.getAllMessageByChatId(messagesByChatRequest);
    }

}
