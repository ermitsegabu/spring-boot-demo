package com.amigos.demo.features.user.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigos.demo.features.user.data.dtos.User;
import com.amigos.demo.features.user.services.UserService;
import com.amigos.demo.features.user.services.UserServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp service;

    @PostMapping()
    public ResponseEntity<String> register(@RequestBody User user) {
        service.register(user);
        return ResponseEntity.ok("registered successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) { 
        service.updateUser(id, user); 
        return ResponseEntity.ok("user updated successfully");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(String id) {
        return ResponseEntity.ok("This works too");
    }


    
}
