package com.registrapp.service;

import com.registrapp.models.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    void addUser(User user) throws NoSuchAlgorithmException;

    void deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> getAllUser();

    void saveOrUpdate(User user);


}
