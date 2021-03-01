package com.buta.inter;

import com.buta.model.User;
import java.util.List;

public interface UserDaoInter {

    public List<User> getAll();

    public List<User> getAll(String firstName, String lastName);

    public User findById(Integer id);

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email);

    public boolean updateUser(User user);

    public boolean removeUser(Integer id);

    public boolean addUser(User user);

}
