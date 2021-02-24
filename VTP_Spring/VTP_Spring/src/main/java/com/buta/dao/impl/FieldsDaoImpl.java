package com.buta.dao.impl;

import com.buta.dao.inter.FieldsDaoInter;
import com.buta.entity.Fields;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("fieldsDao1")
@Transactional
public class FieldsDaoImpl implements FieldsDaoInter {


    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public List<Fields> getAll() {
        String jpq = "SELECT f FROM Fields f";
        Query query = em.createQuery(jpq, Fields.class);
        return query.getResultList();
    }

    @Override
    public Fields findById(Integer id) {
        Fields f = em.find(Fields.class, id);
        return f;
    }

    @Override
    public List<Fields> findByFieldsName(String fieldsName) {
        String jpq = "SELECT f FROM Fields f WHERE f.fieldsName=:fieldsName";
        Query query = em.createQuery(jpq, Fields.class);
        query.setParameter("fieldsName", fieldsName);
        return query.getResultList();
    }

    @Override
    public boolean addFields(Fields f) {
        em.persist(f);
        return true;
    }

    @Override
    public boolean updateFields(Fields f) {
        em.merge(f);
        return true;
    }

    @Override
    public boolean removeFields(Integer id) {
        Fields f = em.find(Fields.class, id);
        em.remove(f);
        return true;
    }

}
