package com.example.chats.service;

import com.example.chats.entity.Chat;
import com.example.chats.entity.Users;
import com.example.chats.model.Result;
import com.example.chats.payload.ChatRequest;
import com.example.chats.payload.GetChatByUserIdRequest;
import com.example.chats.repository.ChatRepository;
import com.example.chats.repository.UsersRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final UsersRepository usersRepository;

    public ResponseEntity createChat(ChatRequest chatRequest){
        Chat chat = new Chat();
        chat.setNames(chatRequest.getName());
        List<Users> userList = new ArrayList<>();
        userList = usersRepository.findAllById(chatRequest.getUsersId());
        chat.setUsersList(userList);
        if (chatRequest.getName()!=null && chatRequest.getUsersId()!=null){
            chatRepository.save(chat);
            return ResponseEntity.ok(new Result(true, chat.getId()));
        }
        else {
            return new ResponseEntity<String>("chat not created because some data is null", HttpStatus.BAD_REQUEST);
        }
    }
    public List<Chat> getAllChatByUser(GetChatByUserIdRequest userId){
        return chatRepository.findChatsByUsersList(usersRepository.getById(userId.getUser()));
    }
}
