package com.dungeon.gamebot.stage;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Stage {
    SendMessage sendMessage(Update update);
}
