package hako.shareEvent.telegram.commands;

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
public class SetNameCommand implements Command {

    private ReplyKeyboardMarkup keyboard;
    private final KeyboardGenerator keyboardGenerator;

    private final UserService userService;

    public SetNameCommand(@Autowired UserService userService,
                        @Autowired KeyboardGenerator keyboardGenerator
    ){
        this.userService = userService;
        this.keyboardGenerator = keyboardGenerator;

        keyboard = generateKeyboard();
    }

    public SendMessage apply(Update update) {
        long chatId = update.getMessage().getChatId();
        
        userService.createNewUser(chatId);
        userService.setChatContext(chatId, ChatContext.SELECT_CITY);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(Consts.START_MESSAGE);

        sendMessage.setReplyMarkup(keyboard);
        return sendMessage;
    }

    private ReplyKeyboardMarkup generateKeyboard() {
        String markup = "";

        return keyboardGenerator.generateReplyMarkup(markup);
    }
}
