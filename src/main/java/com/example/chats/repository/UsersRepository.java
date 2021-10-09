package com.example.chats.repository;

import com.example.chats.entity.Chat;
import com.example.chats.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
//    List<Chat> findAllById(UUID id);

}
