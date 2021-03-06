package com.buta.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "useruniversity")
public class UserUniversity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userUniversityId;

    @ElementCollection
    @CollectionTable(name = "level_of_education", joinColumns = @JoinColumn(name = "userUniversityId"))
    @MapKeyColumn(name = "education_level")
    @Column(name = "course")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<LevelOfEducation, Integer> course = new HashMap<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fields_id", referencedColumnName = "fieldsId")
    private Fields fields;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", referencedColumnName = "universityId")
    private University university;

    @OneToMany(mappedBy = "userUniversity", cascade = CascadeType.ALL)
    private List<User> users;

    public UserUniversity() {
    }

    public Integer getUserUniversityId() {
        return userUniversityId;
    }

    public void setUserUniversityId(Integer userUniversityId) {
        this.userUniversityId = userUniversityId;
    }

    public Map<LevelOfEducation, Integer> getCourse() {
        return course;
    }

    public void setCourse(Map<LevelOfEducation, Integer> course) {
        this.course = course;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
