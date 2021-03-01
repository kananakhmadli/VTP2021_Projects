package com.buta.impl;

import com.buta.inter.AbstractDAO;
import com.buta.inter.UserDaoInter;
import com.buta.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAll() {
        EntityManager em = em();
        String jpq = "SELECT u FROM User u";
        Query query = em.createQuery(jpq, User.class);
        return query.getResultList();
    }

    @Override
    public List<User> getAll(String firstName, String lastName) {
        EntityManager em = em();

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
        EntityManager em = em();
        User u = em.find(User.class, id);
        em.close();
        return u;

    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        EntityManager em = em();
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
        EntityManager em = em();
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
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUser(Integer id) {
        EntityManager em = em();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean addUser(User user) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
