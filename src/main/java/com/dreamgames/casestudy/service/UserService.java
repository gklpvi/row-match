package com.dreamgames.casestudy.service;

import com.dreamgames.casestudy.model.User;

import java.util.List;
public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public int addUser(User student);

    public void deleteUser(int id);
}
