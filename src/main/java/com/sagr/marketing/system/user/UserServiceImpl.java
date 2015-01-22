package com.sagr.marketing.system.user;

import java.util.List;

/**
 * @author AGrintsov
 */
public class UserServiceImpl implements UserService{
    private UserDaoImpl userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(String login) {
        return null;
    }

    @Override
    public boolean registerNewUser(String login, String password) {
        return false;
    }
}
