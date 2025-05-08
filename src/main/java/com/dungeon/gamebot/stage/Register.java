package com.dungeon.gamebot.stage;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Register implements Stage {

    @Override
    public void sendMessage(Update update) {
        Message message = update.getMessage();
        long chatID = message.getChatId();


    }
}
