package com.buta.service.inter;

import com.buta.entity.UserUniversity;

import java.util.List;

public interface UserUniversityServiceInter {

    public List<UserUniversity> getAll();

    public boolean addUserUniversity(UserUniversity uu);

    public boolean updateUserUniversity(UserUniversity uu);

    public boolean removeUserUniversity(Integer id);

}
