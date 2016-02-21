package com.registrapp.service;

import com.registrapp.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> getAllUser();

    void saveOrUpdate(User user);

    void updateUser(User user);

}
