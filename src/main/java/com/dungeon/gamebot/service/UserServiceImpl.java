package com.dungeon.gamebot.service;

import com.dungeon.gamebot.models.User;
import com.dungeon.gamebot.repository.GameData;
import com.dungeon.gamebot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final GameData gameData;

    @Override
    public boolean isRegistered(Long userID) {
        return repo.existsById(userID);
    }

    @Override
    public void registerUser(User user) {
        repo.save(user);
        gameData.pushEvent(user.getChatID(), "Register");
    }

    @Override
    public void deleteUser(Long userID) {
        if (repo.existsById(userID)) {
            repo.deleteById(userID);
            log.info(userID + " удалил свои данные");
        } else {
            log.error("Пользователь не существует");
        }
        gameData.clearAll(userID);
    }

    @Override
    public Optional<User> getUser(Long userID) {
        return repo.findById(userID);
    }
}
