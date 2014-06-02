package com.springapp.services;

import com.springapp.domain.User;

import java.util.List;

public interface UserService {
    public void insertData(User user);
    public List<User> getUserList();
    public void deleteData(String id);
    public User getUser(String id);
    public void updateData(User user);
}
