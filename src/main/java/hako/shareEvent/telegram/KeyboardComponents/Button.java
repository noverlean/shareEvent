package hako.shareEvent.telegram.KeyboardComponents;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Button {

    private String text = "";

    public KeyboardButton compile()
    {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText(text);
        return keyboardButton;
    }
}
