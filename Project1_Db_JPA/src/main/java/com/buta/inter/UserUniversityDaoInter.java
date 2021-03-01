package com.buta.inter;

import com.buta.model.UserUniversity;
import java.util.List;

public interface UserUniversityDaoInter {

    public List<UserUniversity> getAll();

    public boolean addUserUniversity(UserUniversity uu);

    public boolean updateUserUniversity(UserUniversity uu);

    public boolean removeUserUniversity(Integer id);

}
