package com.buta.service.impl;

import com.buta.dao.inter.FieldsDaoInter;
import com.buta.entity.Fields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FieldsServiceImpl implements FieldsDaoInter {

    @Autowired
    @Qualifier("fieldsDao1")
    private FieldsDaoInter fieldsDao;

    @Override
    public List<Fields> getAll() {
        return fieldsDao.getAll();
    }

    @Override
    public Fields findById(Integer id) {
        return fieldsDao.findById(id);
    }

    @Override
    public List<Fields> findByFieldsName(String fieldsName) {
        return fieldsDao.findByFieldsName(fieldsName);
    }

    @Override
    public boolean addFields(Fields f) {
        return fieldsDao.addFields(f);
    }

    @Override
    public boolean updateFields(Fields f) {
        return fieldsDao.updateFields(f);
    }

    @Override
    public boolean removeFields(Integer id) {
        return fieldsDao.removeFields(id);
    }
}
