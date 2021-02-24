package com.buta.service.inter;

import com.buta.entity.Fields;

import java.util.List;

public interface FieldsServiceInter {

    public List<Fields> getAll();

    public Fields findById(Integer id);

    public List<Fields> findByFieldsName(String fieldsName);

    public boolean addFields(Fields f);

    public boolean updateFields(Fields f);

    public boolean removeFields(Integer id);

}
