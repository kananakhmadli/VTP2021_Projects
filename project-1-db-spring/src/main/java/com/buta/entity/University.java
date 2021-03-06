package com.buta.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "university")
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityId;
    private String universityName;

    @OneToOne(mappedBy = "university")
    private UserUniversity userUniversity;

    public University() {
    }

    public University(String universityName) {
        this.universityName = universityName;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public UserUniversity getUserUniversity() {
        return userUniversity;
    }

    public void setUserUniversity(UserUniversity userUniversity) {
        this.userUniversity = userUniversity;
    }

}
