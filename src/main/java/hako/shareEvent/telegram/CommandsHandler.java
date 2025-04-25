package hako.shareEvent.telegram;

import hako.shareEvent.services.UserService;
import hako.shareEvent.telegram.commands.SelectCityCommand;
import hako.shareEvent.telegram.commands.StartCommand;
import hako.shareEvent.utils.Consts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Component
@Slf4j
public class CommandsHandler {
    private final Map<String, Command> commands;

    private final UserService userService;

    public CommandsHandler(
        @Autowired UserService userService,
        @Autowired StartCommand startCommand,
        @Autowired SelectCityCommand selectCityCommand
    ) {
        this.userService = userService;

        this.commands = Map.of(
                "/start", startCommand
        );
    }

    public SendMessage handleCommands(Update update) {
        String messageText = update.getMessage().getText();
        String command = messageText.split(" ")[0];
        long chatId = update.getMessage().getChatId();

        User user = userService.getUser(chatId);

        var commandHandler = commands.get(command);
        if (commandHandler != null) {
            return commandHandler.apply(update);
        } else {
            return new SendMessage(String.valueOf(chatId), Consts.UNKNOWN_COMMAND);
        }
    }
}
