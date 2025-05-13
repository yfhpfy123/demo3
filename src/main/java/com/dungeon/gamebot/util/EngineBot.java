package com.dungeon.gamebot.util;

import com.dungeon.gamebot.repository.GameData;
import com.dungeon.gamebot.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class EngineBot extends TelegramLongPollingBot {
    private final GameData gameData;
    private final Stage register;
    private final Stage mainMenu;

    @Value("${bot.token}")
    String botUsername;

    @Autowired
    public EngineBot(@Value("${bot.token}") String botToken, GameData gameData, Stage register, Stage mainMenu) {
        super(botToken);
        this.gameData = gameData;
        this.register = register;
        this.mainMenu = mainMenu;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        long id = msg.getChatId();
        long msg_id = msg.getMessageId();

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            gameData.pushEvent(id, "Register1");
            try {
                execute(register.sendMessage(update));
            } catch (TelegramApiException e) {

            }

        } else if (update.hasCallbackQuery()) {
            CallbackQuery query = update.getCallbackQuery();
            String q_text = query.getMessage().getText();
            switch (q_text) {
                case "Register2":
                    gameData.pushEvent(id, "Register3");
                    try {
                        execute(register.sendMessage(update));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

            }
        }
    }
}
