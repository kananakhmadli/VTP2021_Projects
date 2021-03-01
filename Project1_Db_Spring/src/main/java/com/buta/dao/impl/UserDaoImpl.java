package com.buta.dao.impl;

import com.buta.dao.inter.UserDaoInter;
import com.buta.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao1")
@Transactional
public class UserDaoImpl implements UserDaoInter {

    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public List<User> getAll() {
        String jpq = "SELECT u FROM User u";
        Query query = em.createQuery(jpq, User.class);
        return query.getResultList();
    }

    @Override
    public List<User> getAll(String firstName, String lastName) {
        String jpq = "SELECT u FROM User u WHERE 1=1";
        if (firstName != null && !firstName.trim().isEmpty()) {
            jpq += " AND firstName=:firstName";

        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            jpq += " AND lastName=:lastName";

        }
        Query query = em.createQuery(jpq, User.class);
        if (firstName != null && !firstName.trim().isEmpty()) {
            query.setParameter("firstName", firstName);

        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            query.setParameter("lastName", lastName);

        }
        return query.getResultList();
    }

    @Override
    public User findById(Integer id) {
        User u = em.find(User.class, id);
        return u;

    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String jpq = "SELECT u FROM User u WHERE email=:email AND password=:password";
        Query query = em.createQuery(jpq, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public User findByEmail(String email) {
        String jpq = "SELECT u FROM User u WHERE email=:email";
        Query query = em.createQuery(jpq, User.class);
        query.setParameter("email", email);
        List<User> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean updateUser(User user) {
        em.merge(user);
        return true;
    }

    @Override
    public boolean removeUser(Integer id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        em.persist(user);
        return true;
    }

}
