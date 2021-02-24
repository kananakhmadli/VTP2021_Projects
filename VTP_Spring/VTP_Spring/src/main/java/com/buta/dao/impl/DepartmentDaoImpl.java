package com.buta.dao.impl;

import com.buta.dao.inter.DepartmentDaoInter;
import com.buta.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("departmentDao1")
@Transactional
public class DepartmentDaoImpl implements DepartmentDaoInter {

    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public Department findById(Integer id) {
        Department d = em.find(Department.class, id);
        return d;
    }

    @Override
    public List<Department> findByName(String name) {
        String jpq = "SELECT d from Department d WHERE d.departmentName=:departmentName";
        Query query = em.createQuery(jpq, Department.class);
        query.setParameter("departmentName", name);
        return query.getResultList();

    }

    @Override
    public List<Department> getAll() {
        String jpq = "SELECT d from Department d";
        Query query = em.createQuery(jpq, Department.class);
        return query.getResultList();
    }

    @Override
    public boolean addDepartment(Department d) {
        em.persist(d);
        return true;
    }

    @Override
    public boolean updateDepartment(Department d) {
        em.merge(d);
        return true;
    }

    @Override
    public boolean removeDepartment(Integer id) {
        Department d = em.find(Department.class, id);
        em.remove(d);
        return true;
    }

}
