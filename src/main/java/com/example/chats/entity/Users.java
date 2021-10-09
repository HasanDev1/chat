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
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users extends AbstractEntity {
    @Column(unique = true)
    private String username;


    @JsonIgnore
    @ManyToMany(mappedBy = "usersList")
    private List<Chat> chatList;
}
