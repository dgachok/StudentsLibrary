package com.registrapp.dao;

import com.registrapp.models.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM user WHERE user.id=?").setParameter(1,id);
        query.executeUpdate();
    }

    @Override
    public User getUserById(Integer id) {
        User userId = (User)sessionFactory.getCurrentSession().createQuery("from User where id=?").setParameter(0,id).uniqueResult();
        return userId;
    }

    @Override
    public User getUserByUsername(String username) {
        User userUsername = (User)sessionFactory.getCurrentSession().createQuery("FROM User where firstname = ?").setParameter(0,username).uniqueResult();
        return userUsername;
    }

    @Override
    public User getUserByEmail(String email) {
        User userUsername = (User)sessionFactory.getCurrentSession().createQuery("FROM User where email = ?").setParameter(0,email).uniqueResult();
        return userUsername;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users= (List<User>)sessionFactory.getCurrentSession().createQuery("FROM User").list();
        return users;
    }

    @Override
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
