package hako.shareEvent.telegram.commands;

import hako.shareEvent.entities.User;
import hako.shareEvent.services.UserService;
import hako.shareEvent.telegram.ChatContext;
import hako.shareEvent.telegram.Command;
import hako.shareEvent.utils.Consts;
import hako.shareEvent.utils.KeyboardGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class SelectCityCommand implements Command {

    private ReplyKeyboardMarkup keyboard;
    private final KeyboardGenerator keyboardGenerator;

    private final UserService userService;

    public SelectCityCommand(@Autowired UserService userService,
                        @Autowired KeyboardGenerator keyboardGenerator
    ){
        this.userService = userService;
        this.keyboardGenerator = keyboardGenerator;

        keyboard = generateKeyboard();
    }

    public SendMessage apply(Update update) {
        long chatId = update.getMessage().getChatId();
        String name = update.getMessage().getText();
        
        User user = userService.getUser(chatId);
        user.setName(name);
        userService.save(user);
        
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(Consts.START_MESSAGE);

        sendMessage.setReplyMarkup(keyboard);
        return sendMessage;
    }

    private ReplyKeyboardMarkup generateKeyboard() {
        String markup = "Меню";

        return keyboardGenerator.generateReplyMarkup(markup);
    }
}
