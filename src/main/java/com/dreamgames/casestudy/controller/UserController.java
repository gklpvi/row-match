package com.dreamgames.casestudy.controller;

import com.dreamgames.casestudy.model.User;
import com.dreamgames.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/CreateUserRequest")
    public ResponseEntity<Integer> add() {
    //try{}catch{}
        User user = new User("", 1, 5000);
        userService.addUser(user);
        return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);

    }
    @GetMapping("/UpdateLevelRequest/{id}")
    public ResponseEntity<User> updateLevel(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            user.setUserLevel(user.getUserLevel() + 1);
            user.setUserCoin(user.getUserCoin() + 25);
            userService.addUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            userService.addUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        userService.deleteUser(id);
    }
}
