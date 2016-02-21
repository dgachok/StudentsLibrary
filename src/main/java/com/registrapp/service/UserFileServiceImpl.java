package com.registrapp.service;


import com.registrapp.dao.UserFileDao;
import com.registrapp.models.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private UserFileDao userFileDao;

    public UserFile findById(int id) {
        return userFileDao.findById(id);
    }

    @Override
    public void save(UserFile file) {
        userFileDao.save(file);
    }

    public List<UserFile> findAll() {
        return userFileDao.findAll();
    }

    public List<UserFile> findAllByUserId(int userId) {
        return userFileDao.findAllByUserId(userId);
    }

    public void deleteById(int id){
        userFileDao.deleteById(id);
    }

    public UserFileDao getUserFileDao() {
        return userFileDao;
    }

    public void setUserFileDao(UserFileDao userFileDao) {
        this.userFileDao = userFileDao;
    }
}
