package com.sagr.marketing.system.user;

import java.util.List;

/**
 * @author AGrintsov
 */
public interface IUserService {
    void add(User user);
    void update(User user);
    User getById(Integer id);
    List<User> getAll();
    User get(String login);
    boolean registerNewUser(User user, String password);
    User getUserByLogin(String login);
}
