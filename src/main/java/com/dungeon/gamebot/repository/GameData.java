package com.dungeon.gamebot.repository;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameData {
    private final Map<Long, Deque<String>> gameStage = new ConcurrentHashMap<>();

    public void pushEvent(Long chatID, String stage) {
        gameStage
                .computeIfAbsent(chatID, id -> new ArrayDeque<>())
                .push(stage);
    }

    public String getStage(Long chatID) {
        return gameStage
                .get(chatID)
                .peek();
    }

    public void turnBack(Long chatID) {
        gameStage
                .get(chatID)
                .pop();
    }

    public void clearAll(Long chatID) {
        gameStage
                .get(chatID)
                .clear();
    }

    public void clearToMain(Long chatID) {
        clearAll(chatID);
        gameStage
                .get(chatID)
                .push("Register");
    }
}
