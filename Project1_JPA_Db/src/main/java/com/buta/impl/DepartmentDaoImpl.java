package com.buta.impl;

import com.buta.inter.AbstractDAO;
import com.buta.inter.DepartmentDaoInter;
import com.buta.model.Department;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DepartmentDaoImpl extends AbstractDAO implements DepartmentDaoInter {

    @Override
    public Department findById(Integer id) {
        EntityManager em = em();
        Department d = em.find(Department.class, id);
        em.clear();
        return d;
    }

    @Override
    public List<Department> findByName(String name) {
        EntityManager em = em();
        String jpq = "SELECT d from Department d WHERE d.departmentName=:departmentName";
        Query query = em.createQuery(jpq, Department.class);
        query.setParameter("departmentName", name);
        return query.getResultList();

    }

    @Override
    public List<Department> getAll() {
        EntityManager em = em();
        String jpq = "SELECT d from Department d";
        Query query = em.createQuery(jpq, Department.class);
        return query.getResultList();
    }

    @Override
    public boolean addDepartment(Department d) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateDepartment(Department d) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeDepartment(Integer id) {
        EntityManager em = em();
        Department d = em.find(Department.class, id);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
