package com.buta.dao.impl;

import com.buta.dao.inter.UserUniversityDaoInter;
import com.buta.entity.UserUniversity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userUniversityDao1")
@Transactional
public class UserUniversityDaoImpl implements UserUniversityDaoInter {

    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public List<UserUniversity> getAll() {
        String jpq = "SELECT uu FROM UserUniversity uu ";
        Query q = em.createQuery(jpq, UserUniversity.class);
        return q.getResultList();
    }

    @Override
    public boolean addUserUniversity(UserUniversity uu) {
        em.persist(uu);
        return true;
    }

    @Override
    public boolean updateUserUniversity(UserUniversity uu) {
        em.merge(uu);
        return true;
    }

    @Override
    public boolean removeUserUniversity(Integer id) {
        UserUniversity uu = em.find(UserUniversity.class, id);
        em.remove(uu);
        return true;
    }

}
