package com.sagr.marketing.system.user;

import java.util.List;

/**
 * @author AGrintsov
 */
public interface UserService {
    void add(User user);
    void update(User user);
    User getById(Integer id);
    List<User> getAll();
    User get(String login);
    boolean registerNewUser(String login, String password);
}
