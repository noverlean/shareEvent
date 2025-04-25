package hako.shareEvent.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import hako.shareEvent.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findByChatId(Long chatId);
}
