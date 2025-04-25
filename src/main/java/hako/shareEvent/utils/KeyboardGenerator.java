package hako.shareEvent.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import hako.shareEvent.telegram.KeyboardComponents.Button;

@Component
public class KeyboardGenerator {
    public ReplyKeyboardMarkup generateReplyMarkup(String keyboardStructure)
    {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        
        List<KeyboardRow> rows = new ArrayList<>();
        
        
        for (String rowStructure : keyboardStructure.split("~"))
        {
            KeyboardRow row = new KeyboardRow();
            rows.add(row);
            for (String buttonContent : rowStructure.split("█"))
            {
                KeyboardButton button = new Button().setText(buttonContent.trim()).compile();
                row.add(button);
            }
        }

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
}
