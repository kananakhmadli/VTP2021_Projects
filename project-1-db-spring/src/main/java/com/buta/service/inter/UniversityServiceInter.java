package com.buta.service.inter;

import com.buta.entity.University;

import java.util.List;

public interface UniversityServiceInter {

    public List<University> getALl();

    public University findById(Integer id);

    public List<University> findByUniversityName(String universityName);

    public boolean addUniversity(University u);

    public boolean updateUniversity(University u);

    public boolean removeUniversity(Integer id);

}
