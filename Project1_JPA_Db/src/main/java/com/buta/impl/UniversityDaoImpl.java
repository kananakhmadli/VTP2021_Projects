package com.buta.impl;

import com.buta.inter.AbstractDAO;
import com.buta.inter.UniversityDaoInter;
import com.buta.model.University;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UniversityDaoImpl extends AbstractDAO implements UniversityDaoInter {

    @Override
    public List<University> getALl() {
        EntityManager em = em();
        String jpq = "SELECT uni FROM University uni ";
        Query q = em.createQuery(jpq, University.class);
        return q.getResultList();
    }

    @Override
    public University findById(Integer id) {
        EntityManager em = em();
        University uni = em.find(University.class, id);
        em.close();
        return uni;
    }

    @Override
    public List<University> findByUniversityName(String universityName) {
        EntityManager em = em();
        String jpq = "SELECT uni FROM University uni WHER uni.universityName=:universityName ";
        Query q = em.createQuery(jpq, University.class);
        q.setParameter("universityName", universityName);
        return q.getResultList();
    }

    @Override
    public boolean addUniversity(University u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateUniversity(University u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUniversity(Integer id) {
        EntityManager em = em();
        University uni = em.find(University.class, id);
        em.getTransaction().begin();
        em.remove(uni);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
