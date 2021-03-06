package com.registrapp.service;

import com.registrapp.dao.UserDao;
import com.registrapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    Md5PasswordEncoder encoder;

    @Override
    public void addUser(User user) throws NoSuchAlgorithmException {
        user.setSsoId(new Random(System.currentTimeMillis()).nextInt(1000000) + 10000);
        user.setUser_role_id(1);
        user.setAccount_status("disabled");
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(encoder.encodePassword(user.getPassword(), ""));
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void saveOrUpdate(User user) throws NoSuchAlgorithmException {
        userDao.saveOrUpdate(user);
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
