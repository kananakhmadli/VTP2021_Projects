package com.buta.dao.inter;

import com.buta.entity.University;

import java.util.List;

public interface UniversityDaoInter {

    public List<University> getALl();

    public University findById(Integer id);

    public List<University> findByUniversityName(String universityName);

    public boolean addUniversity(University u);

    public boolean updateUniversity(University u);

    public boolean removeUniversity(Integer id);

}
