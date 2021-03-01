package com.buta.inter;

import java.util.List;
import com.buta.model.Department;

public interface DepartmentDaoInter {

    public Department findById(Integer id);

    public List<Department> findByName(String name);

    public List<Department> getAll();

    public boolean addDepartment(Department d);

    public boolean updateDepartment(Department d);

    public boolean removeDepartment(Integer id);

}
