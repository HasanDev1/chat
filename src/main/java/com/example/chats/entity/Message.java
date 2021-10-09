package com.example.chats.entity;


import com.example.chats.entity.abstractEntity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Message extends AbstractEntity {

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    private Chat chat;

    @JsonIgnore
    @ManyToOne
    private Users author;

}
