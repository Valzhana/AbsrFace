package src.personal.controllers;

import src.personal.model.Repository;
import src.personal.model.User;
import src.personal.model.ValidateUser;

import java.util.List;


public class UserController {
    private final Repository repository;

    private final ValidateUser validator = new ValidateUser();

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) throws Exception {
        validator.check(user);
        repository.createUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("Контакт не найден");
    }

    public List<User> readUsers() {
        List<User> users = repository.getAllUsers();
        return users;
    }

    public void deleteUser(String userId) {
        repository.deleteUser(userId);
    }
    public void updateUserName(String userId) {
        repository.updateUserName(userId);
    }
    public void updateLastName(String userId) {
        repository.updateLastName(userId);
    }
    public void updatePhoneNumber(String userId) {
        repository.updatePhoneNumber(userId);
    }
}
