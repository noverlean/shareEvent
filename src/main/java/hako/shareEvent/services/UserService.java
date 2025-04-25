package hako.shareEvent.services;

import hako.shareEvent.entities.User;
import hako.shareEvent.telegram.ChatContext;

public interface UserService {
    void createNewUser(Long chatId);
    User getUser(Long chatId);
    void setChatContext(Long chatId, ChatContext chatContext);
}
