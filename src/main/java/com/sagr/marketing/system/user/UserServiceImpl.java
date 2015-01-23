package com.sagr.marketing.system.user;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author AGrintsov
 */
public class UserServiceImpl implements UserService {
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

    public String generatePasswordHash(String login, String password) throws Exception {
        String plainText = login + password + "bla";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e.getMessage());
        }
        try {
            md.update(plainText.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e.getMessage());
        }
        byte raw[] = md.digest();
        String hash = (new BASE64Encoder()).encode(raw);
        return hash;
    }
}
