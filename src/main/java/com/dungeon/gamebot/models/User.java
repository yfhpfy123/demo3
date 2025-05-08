package com.dungeon.gamebot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    private long chatID;
    private String username;
    private boolean isRegistered;
    private long registeredAt; // по Unix (currentTimeMills)
    private String charName; // Имя игрового персонажа
    private String gender;

    public User() {
    }
}
