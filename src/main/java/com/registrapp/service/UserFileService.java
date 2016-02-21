package com.registrapp.service;

import com.registrapp.models.UserFile;

import java.util.List;

public interface UserFileService {

    List<UserFile> findAll();

    UserFile findById(int id);

    void save(UserFile file);

    List<UserFile> findAllByUserId(int userId);

    void deleteById(int id);
}
