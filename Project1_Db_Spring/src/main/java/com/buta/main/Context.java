package com.buta.main;

import com.buta.dao.impl.*;
import com.buta.dao.inter.*;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static DepartmentDaoInter instaceDepartment() {
        return new DepartmentDaoImpl();
    }

    public static FieldsDaoInter instaceFields() {
        return new FieldsDaoImpl();
    }

    public static UniversityDaoInter instanceUniversity() {
        return new UniversityDaoImpl();
    }

    public static UserUniversityDaoInter instanceUserUni() {
        return new UserUniversityDaoImpl();
    }
}
