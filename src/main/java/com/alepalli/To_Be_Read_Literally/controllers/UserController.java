package com.alepalli.To_Be_Read_Literally.controllers;


import com.alepalli.To_Be_Read_Literally.entities.User;
import com.alepalli.To_Be_Read_Literally.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
}
