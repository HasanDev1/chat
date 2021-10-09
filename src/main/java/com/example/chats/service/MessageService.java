package com.example.chats.service;

import com.example.chats.entity.Message;
import com.example.chats.exceptions.ResourceNotFoundException;
import com.example.chats.model.Result;
import com.example.chats.payload.MessageRequest;
import com.example.chats.payload.MessagesByChatRequest;
import com.example.chats.repository.ChatRepository;
import com.example.chats.repository.MessageRepository;
import com.example.chats.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final ChatRepository chatRepository;
    private final UsersRepository usersRepository;
    private final MessageRepository messageRepository;

    public ResponseEntity createMessage(MessageRequest messageRequest){
        Message message = new Message();
        message.setText(messageRequest.getText());
        message.setChat(chatRepository.findById(messageRequest.getChatId()).orElseThrow(() -> new ResourceNotFoundException("not found chat")));
        message.setAuthor(usersRepository.findById(messageRequest.getUserId()).orElseThrow(() -> new ResourceNotFoundException("not found author")));
        if (messageRequest.getText()!=null && messageRequest.getChatId()!=null && messageRequest.getUserId()!=null){
            messageRepository.save(message);
            return ResponseEntity.ok(new Result(true, message.getId()));
        }else {
            return new ResponseEntity<String>("message not created because some data is null", HttpStatus.BAD_REQUEST);
        }

    }

//    public List<Message> getAllMessageByChatId(UUID chatId){
//        return messageRepository.findAllByChatIdOrderByCreateAt(chatId);
//    }

    public ResponseEntity getAllMessageByChatId(MessagesByChatRequest messagesByChatRequest){
        if (messagesByChatRequest.getChatId()!=null){
            List<Message> messageList = messageRepository.findAllByChatIdOrderByCreateAt(messagesByChatRequest.getChatId());
            return messageRepository.findAllByChatIdOrderByCreateAt(messagesByChatRequest.getChatId())!=null? ResponseEntity.ok(messageList)
                    : new ResponseEntity<String>("not messages", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<String>("request data is null", HttpStatus.BAD_REQUEST);
        }
    }
}
