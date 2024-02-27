package prom.it.service;

import prom.it.entity.Vocabulary;
import prom.it.entity.security.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    Boolean deleteUser(Long id);
    User getById(Long id);
    User updateUser(User user);
    List<User> getAll();

}
