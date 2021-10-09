package com.example.chats.service;

import com.example.chats.entity.Users;
import com.example.chats.model.Result;
import com.example.chats.payload.UserRequest;
import com.example.chats.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public ResponseEntity addUser(UserRequest userRequest) {
        Users users = new Users();
        users.setUsername(userRequest.getUsername());
        if(userRequest.getUsername()!=null){
            usersRepository.save(users);
            return ResponseEntity.ok(new Result(true, users.getId()));
        }else {
           return new ResponseEntity<String>("user not added because some data is null", HttpStatus.BAD_REQUEST);
        }
    }
}
