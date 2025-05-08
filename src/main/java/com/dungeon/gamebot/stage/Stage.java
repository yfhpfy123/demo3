package com.dungeon.gamebot.stage;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Stage {
    void sendMessage(Update update);
}
