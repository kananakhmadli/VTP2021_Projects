package com.buta.impl;

import com.buta.inter.AbstractDAO;
import com.buta.inter.UserUniversityDaoInter;
import com.buta.model.UserUniversity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserUniversityDaoImpl extends AbstractDAO implements UserUniversityDaoInter {

    @Override
    public List<UserUniversity> getAll() {
        EntityManager em = em();
        String jpq = "SELECT uu FROM UserUniversity uu ";
        Query q = em.createQuery(jpq, UserUniversity.class);
        return q.getResultList();
    }

    @Override
    public boolean addUserUniversity(UserUniversity uu) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.remove(uu);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateUserUniversity(UserUniversity uu) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.remove(uu);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUserUniversity(Integer id) {
        EntityManager em = em();
        UserUniversity uu = em.find(UserUniversity.class, id);
        em.getTransaction().begin();
        em.remove(uu);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
