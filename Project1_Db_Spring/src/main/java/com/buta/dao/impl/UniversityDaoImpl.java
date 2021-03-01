package com.buta.dao.impl;

import com.buta.dao.inter.UniversityDaoInter;
import com.buta.entity.University;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("universityDao1")
@Transactional
public class UniversityDaoImpl implements UniversityDaoInter {

    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public List<University> getALl() {
        String jpq = "SELECT uni FROM University uni ";
        Query q = em.createQuery(jpq, University.class);
        return q.getResultList();
    }

    @Override
    public University findById(Integer id) {
        University uni = em.find(University.class, id);
        return uni;
    }

    @Override
    public List<University> findByUniversityName(String universityName) {
        String jpq = "SELECT uni FROM University uni WHERE uni.universityName=:universityName ";
        Query q = em.createQuery(jpq, University.class);
        q.setParameter("universityName", universityName);
        return q.getResultList();
    }

    @Override
    public boolean addUniversity(University u) {
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateUniversity(University u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUniversity(Integer id) {
        University uni = em.find(University.class, id);
        em.remove(uni);
        return true;
    }

}
