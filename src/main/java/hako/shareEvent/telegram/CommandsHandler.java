package hako.shareEvent.telegram;

import hako.shareEvent.entities.User;
import hako.shareEvent.services.UserService;
import hako.shareEvent.telegram.commands.*;
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
    private final Map<ChatContext, Command> replies;

    private final UserService userService;

    public CommandsHandler(
        @Autowired UserService userService,

        @Autowired StartCommand startCommand,
        @Autowired SelectCityCommand selectCityCommand,
        @Autowired SetNameCommand setNameCommand
    ) {
        this.userService = userService;

        this.commands = Map.of(
            "/start", startCommand
        );

        this.replies = Map.of(
            ChatContext.START, selectCityCommand,
            ChatContext.SELECT_CITY, setNameCommand
        );
    }

    public SendMessage handleCommands(Update update) {
        String messageText = update.getMessage().getText();
        String commandStr = messageText.split(" ")[0];
        long chatId = update.getMessage().getChatId();

        Command command = null;
        if (commands.containsKey(commandStr)) {
            command = commands.get(commandStr);
        } else {
            User user = userService.getUser(chatId);
            command = replies.get(user.getChatContext());
        }
        
        if (command == null)
        {
            return new SendMessage(String.valueOf(chatId), Consts.UNKNOWN_COMMAND);
        }

        return command.apply(update);
    }
}
