package com.buta.service.inter;

import com.buta.entity.Department;

import java.util.List;

public interface DepartmenServiceInter {

    public Department findById(Integer id);

    public List<Department> findByName(String name);

    public List<Department> getAll();

    public boolean addDepartment(Department d);

    public boolean updateDepartment(Department d);

    public boolean removeDepartment(Integer id);

}
