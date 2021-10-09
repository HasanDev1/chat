package com.example.chats.entity;

import com.example.chats.entity.abstractEntity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Chat extends AbstractEntity {
    @Column(unique = true)
    private String names;

    @JsonIgnore
    @ManyToMany
    private List<Users> usersList;

//    @OneToMany(mappedBy ="chat")
//    private List<Message>messageList;
}
