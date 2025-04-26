package hako.shareEvent.services;

import java.time.LocalDateTime;

import hako.shareEvent.entities.User;
import hako.shareEvent.exceptions.custom.ChatIdNotFoundException;
import hako.shareEvent.repositories.UserRepository;
import hako.shareEvent.telegram.ChatContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createNewUser(Long chatId) {
        // if (userRepository.findByChatId(chatId).isPresent()) {
            
        // } //todo

        User user = new User().setChatId(chatId).setRegisteredAt(LocalDateTime.now());
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
    
    public void save(User user)
    {
        userRepository.save(user);
    }
}
