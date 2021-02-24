package com.buta.service.impl;

import com.buta.dao.inter.UserDaoInter;
import com.buta.entity.User;
import com.buta.service.inter.UserServerInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserServerInter {

    @Autowired
    @Qualifier("userDao1")
    private UserDaoInter userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> getAll(String firstName, String lastName) {
        return userDao.getAll(firstName, lastName);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean removeUser(Integer id) {
        return userDao.removeUser(id);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
//data access object

}
