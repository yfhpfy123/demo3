package com.dungeon.gamebot.stage;

import com.dungeon.gamebot.repository.GameData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Register implements Stage {

    private final GameData gameData;

    @Override
    public SendMessage sendMessage(Update update) {
        Message msg = update.getMessage();
        long chatID = msg.getChatId();
        SendMessage sendmsg = new SendMessage();

        if (gameData.getStage(chatID).equals("Register1")) {
            sendmsg.setText("Привет, " + msg.getChat().getUserName() + """
                , это мой первый проект в таком формате,
                поэтому прошу не судить строго,
                тем более я делал проект в full-соло.
                По всем вопросам можешь написать мне с помощью бота
                -команда /help
                
                Для продолжения необходимо 
                пройти начальную регистрацию.""");
            sendmsg.setChatId(chatID);

            InlineKeyboardButton next_button = new InlineKeyboardButton("Далее");
            next_button.setCallbackData("Register2");
            InlineKeyboardMarkup markup = new InlineKeyboardMarkup(List.of(
                    List.of(next_button)));

            sendmsg.setReplyMarkup(markup);
        } else if (gameData.getStage(chatID).equals("Register2")) {
            sendmsg.setText("""
                Выберите рассу персонажа
                
                P.S. Если нажать на название
                 появится описание рассы.
                 Затем нажмите далее, если 
                 расса вам подходит.
                 Выбрать рассу снова, 
                 можно только удалив персонажа
                 или купив в магазине портал
                 в мультивселенную""");


            sendmsg.setChatId(chatID);

            InlineKeyboardButton human = new InlineKeyboardButton("Человек");
            human.setCallbackData("human_desc");

            InlineKeyboardButton hi_ork = new InlineKeyboardButton("Высший орк");
            hi_ork.setCallbackData("hi-ork_desc");

            InlineKeyboardButton dwarf = new InlineKeyboardButton("Гном");
            dwarf.setCallbackData("dwarf_desc");

            InlineKeyboardButton forest_elf = new InlineKeyboardButton("Лесной эльф");
            forest_elf.setCallbackData("f-elf_desc");

            InlineKeyboardButton nag = new InlineKeyboardButton("Наг");
            nag.setCallbackData("nag_desc");

            InlineKeyboardButton morphid = new InlineKeyboardButton("Морфид");
            morphid.setCallbackData("morphid_desc");

            InlineKeyboardButton argen = new InlineKeyboardButton("Арген");
            argen.setCallbackData("argen_desc");

            InlineKeyboardButton meridian = new InlineKeyboardButton("Меридианец");
            meridian.setCallbackData("meridian_desc");

            InlineKeyboardButton jasper = new InlineKeyboardButton("Яспер");
            jasper.setCallbackData("jasper_desc");

            InlineKeyboardButton tech_human = new InlineKeyboardButton("Технолюды");
            tech_human.setCallbackData("tech-human_desc");


            InlineKeyboardMarkup markup = new InlineKeyboardMarkup(List.of(
                    List.of(human),
                    List.of(hi_ork),
                    List.of(dwarf),
                    List.of(forest_elf),
                    List.of(nag),
                    List.of(morphid),
                    List.of(argen),
                    List.of(meridian),
                    List.of(jasper),
                    List.of(tech_human)
            ));

            sendmsg.setReplyMarkup(markup);
        } else if (gameData.getStage(chatID).equals("Register3")) {

        }

        return sendmsg;

    }
}
