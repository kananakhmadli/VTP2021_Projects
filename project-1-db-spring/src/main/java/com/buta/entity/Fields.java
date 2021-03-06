package com.buta.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fields")
public class Fields implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fieldsId;
    private String fieldsName;

    @OneToOne(mappedBy = "fields")
    private UserUniversity userUniversity;

    public Fields() {
    }

    public Fields(String fieldsName) {
        this.fieldsName = fieldsName;
    }

    public Integer getFieldsId() {
        return fieldsId;
    }

    public void setFieldsId(Integer fieldsId) {
        this.fieldsId = fieldsId;
    }

    public String getFieldsName() {
        return fieldsName;
    }

    public void setFieldsName(String fieldsName) {
        this.fieldsName = fieldsName;
    }

    public UserUniversity getUserUniversity() {
        return userUniversity;
    }

    public void setUserUniversity(UserUniversity userUniversity) {
        this.userUniversity = userUniversity;
    }

}
