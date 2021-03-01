package com.buta.service.impl;

import com.buta.dao.inter.DepartmentDaoInter;
import com.buta.dao.inter.UserDaoInter;
import com.buta.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentDaoInter {

    @Autowired
    @Qualifier("departmentDao1")
    private DepartmentDaoInter departmentDao;

    @Override
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentDao.findByName(name);
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    @Override
    public boolean addDepartment(Department d) {
        return departmentDao.addDepartment(d);
    }

    @Override
    public boolean updateDepartment(Department d) {
        return departmentDao.updateDepartment(d);
    }

    @Override
    public boolean removeDepartment(Integer id) {
        return departmentDao.removeDepartment(id);
    }
}
