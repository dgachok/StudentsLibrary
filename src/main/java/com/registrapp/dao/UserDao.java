package com.registrapp.dao;

import com.registrapp.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> getAllUser();

    void saveOrUpdate(User user);

}
