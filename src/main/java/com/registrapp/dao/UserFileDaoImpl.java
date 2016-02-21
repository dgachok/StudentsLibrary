package com.registrapp.dao;

import com.registrapp.models.User;
import com.registrapp.models.UserFile;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserFileDaoImpl implements UserFileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserFile> findAll() {
        List<UserFile> files= (List<UserFile>)sessionFactory.getCurrentSession().createQuery("FROM UserFile ORDER BY id DESC ").list();
        return files;
    }

    @Override
    public UserFile findById(int id) {
        UserFile fileId = (UserFile) sessionFactory.getCurrentSession().createQuery("from UserFile where id=?").setParameter(0,id).uniqueResult();
        return fileId;
    }

    @Override
    public void save(UserFile file) {
       sessionFactory.getCurrentSession().save(file);
    }

    @Override
    public List<UserFile> findAllByUserId(int userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserFile.class).addOrder(Order.desc("id")).createCriteria("user");
        crit.add(Restrictions.eq("id", userId));

        return (List<UserFile>)crit.list();

        // SELECT * FROM user_file WHERE user_file.id=userId
    }

    @Override
    public void deleteById(int id) {
        UserFile userfile = (UserFile) sessionFactory.getCurrentSession().get(UserFile.class, id);
        sessionFactory.getCurrentSession().delete(userfile);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
