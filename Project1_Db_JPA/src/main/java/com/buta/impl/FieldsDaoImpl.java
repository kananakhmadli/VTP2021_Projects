package com.buta.impl;

import com.buta.inter.AbstractDAO;
import com.buta.inter.FieldsDaoInter;
import com.buta.model.Fields;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FieldsDaoImpl extends AbstractDAO implements FieldsDaoInter {

    @Override
    public List<Fields> getAll() {
        EntityManager em = em();
        String jpq = "SELECT f FROM Fields f";
        Query query = em.createQuery(jpq, Fields.class);
        em.close();
        return query.getResultList();
    }

    @Override
    public Fields findById(Integer id) {
        EntityManager em = em();
        Fields f = em.find(Fields.class, id);
        em.close();
        return f;
    }

    @Override
    public List<Fields> findByFieldsName(String fieldsName) {
        EntityManager em = em();
        String jpq = "SELECT f FROM Fields f WHERE f.fieldsName=:fieldsName";
        Query query = em.createQuery(jpq, Fields.class);
        query.setParameter("fieldsName", fieldsName);
        em.close();
        return query.getResultList();
    }

    @Override
    public boolean addFields(Fields f) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateFields(Fields f) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeFields(Integer id) {
        EntityManager em = em();
        Fields f = em.find(Fields.class, id);
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
