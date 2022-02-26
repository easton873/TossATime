package DAO;

import Model.User;

public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    User getUser(String username, String password);
}
