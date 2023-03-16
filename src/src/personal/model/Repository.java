package src.personal.model;

import java.util.List;

public interface Repository {

    List<User> getAllUsers();
    String createUser(User user);

    void deleteUser(String userId);

    void updateUserName(String userId);

    void updateLastName(String userId);


    void updatePhoneNumber(String userId);

}
