package com.dungeon.gamebot.service;

import com.dungeon.gamebot.models.User;

import java.util.Optional;

public interface UserService {

    boolean isRegistered(Long userID);

    void registerUser(User user);

    void deleteUser(Long userID);

    Optional<User> getUser(Long userID);
}
