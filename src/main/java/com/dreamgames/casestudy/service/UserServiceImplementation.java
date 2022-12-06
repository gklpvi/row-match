package com.dreamgames.casestudy.service;

import com.dreamgames.casestudy.model.User;
import com.dreamgames.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public int addUser(User user) {
        userRepository.save(user);
        return user.getId();
    }
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }


}
