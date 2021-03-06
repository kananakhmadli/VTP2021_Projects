package com.buta.service.impl;

import com.buta.dao.inter.UserUniversityDaoInter;
import com.buta.entity.UserUniversity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserUniversityServiceImpl implements UserUniversityDaoInter {

    @Autowired
    @Qualifier("userUniversityDao1")
    private UserUniversityDaoInter userUniversityDao;

    @Override
    public List<UserUniversity> getAll() {
        return userUniversityDao.getAll();
    }

    @Override
    public boolean addUserUniversity(UserUniversity uu) {
        return userUniversityDao.addUserUniversity(uu);
    }

    @Override
    public boolean updateUserUniversity(UserUniversity uu) {
        return userUniversityDao.updateUserUniversity(uu);
    }

    @Override
    public boolean removeUserUniversity(Integer id) {
        return userUniversityDao.removeUserUniversity(id);
    }
}
