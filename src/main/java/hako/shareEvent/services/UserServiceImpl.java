package hako.shareEvent.services;

import hako.shareEvent.entities.User;
import hako.shareEvent.exceptions.custom.ChatIdNotFoundException;
import hako.shareEvent.repositories.UserRepository;
import hako.shareEvent.telegram.ChatContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createNewUser(Long chatId) {
        // if (userRepository.findByChatId(chatId).isPresent()) {
            
        // }

        User user = new User().setChat_id(chatId);
        userRepository.save(user);
    }

    @Override
    public User getUser(Long chatId) throws ChatIdNotFoundException {
        return userRepository.findByChatId(chatId).orElseThrow(() -> new ChatIdNotFoundException());
    }

    @Override
    public void setChatContext(Long chatId, ChatContext chatContext) {
        User user = userRepository.findByChatId(chatId).orElseThrow(() -> new ChatIdNotFoundException());
        user.setChatContext(chatContext);
        userRepository.save(user);
    }
    
}
