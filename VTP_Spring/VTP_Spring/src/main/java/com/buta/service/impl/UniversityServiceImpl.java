package com.buta.service.impl;

import com.buta.dao.inter.UniversityDaoInter;
import com.buta.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UniversityServiceImpl implements UniversityDaoInter {

    @Autowired
    @Qualifier("universityDao1")
    private UniversityDaoInter universityDao;

    @Override
    public List<University> getALl() {
        return universityDao.getALl();
    }

    @Override
    public University findById(Integer id) {
        return universityDao.findById(id);
    }

    @Override
    public List<University> findByUniversityName(String universityName) {
        return universityDao.findByUniversityName(universityName);
    }

    @Override
    public boolean addUniversity(University u) {
        return universityDao.addUniversity(u);
    }

    @Override
    public boolean updateUniversity(University u) {
        return universityDao.updateUniversity(u);
    }

    @Override
    public boolean removeUniversity(Integer id) {
        return universityDao.removeUniversity(id);
    }
}
