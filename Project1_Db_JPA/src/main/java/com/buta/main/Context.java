package com.buta.main;

import com.buta.impl.DepartmentDaoImpl;
import com.buta.impl.FieldsDaoImpl;
import com.buta.impl.UniversityDaoImpl;
import com.buta.impl.UserDaoImpl;
import com.buta.impl.UserUniversityDaoImpl;
import com.buta.inter.DepartmentDaoInter;
import com.buta.inter.FieldsDaoInter;
import com.buta.inter.UniversityDaoInter;
import com.buta.inter.UserDaoInter;
import com.buta.inter.UserUniversityDaoInter;



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
