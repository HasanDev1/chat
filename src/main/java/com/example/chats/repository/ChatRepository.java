package com.example.chats.repository;

import com.example.chats.entity.Chat;
import com.example.chats.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.lang.String;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID> {
//    @Query(value="select chu.chat_list_id as id from Users u inner join chat_users_list chu on chu.users_list_id=u.id where u.id = (:ids)", nativeQuery = true)
//    List<ChatPayload> findAllByUsersListIn(@Param("ids") UUID ids);

    List<Chat> findChatsByUsersList(Users id );


}

