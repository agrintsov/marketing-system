package com.sagr.marketing.system.user;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author AGrintsov
 */
public class UserService implements IUserService {
    private UserDaoImpl userDao;
    private User currentUser;

    @Inject
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User get(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public boolean registerNewUser(User user, String password) {
        if (userDao.getUserByLogin(user.getLogin()) != null)
            return false;
        String passwordHash = generatePasswordHash(user.getLogin(), password);
        user.setPasswordHash(passwordHash);
        add(user);
        return true;
    }

    public boolean signIn(String login, String password) {
        User user = getUserByLogin(login);
        if (user == null) {
            return false;
        }
        String passwordHash = generatePasswordHash(login, password);
        String userPasswordHash = user.getPasswordHash();
        if (!userPasswordHash.equals(passwordHash)) {
            return false;
        }
        currentUser = user;
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    public String generatePasswordHash(String login, String password){
        String plainText = login + password + "bla";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            md.update(plainText.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
        byte raw[] = md.digest();
        String hash = (new BASE64Encoder()).encode(raw);
        return hash;
    }
}
