package prom.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prom.it.entity.Vocabulary;
import prom.it.entity.security.User;
import prom.it.repository.UserRepository;
import prom.it.repository.VocabularyRepository;
import prom.it.service.UserService;
import prom.it.service.VocabularyService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseGet(User::new);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
