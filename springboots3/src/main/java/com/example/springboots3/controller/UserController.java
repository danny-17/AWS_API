package com.example.springboots3.controller;

import com.example.springboots3.entity.User;
import com.example.springboots3.repository.UserRepository;
import com.example.springboots3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    private UserRepository userR;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    List<User> getAll(){
        return userR.findAll()
                .stream()
                .peek(user-> user.setImagenUrl(s3Service.getObjectUrl(user.getImagenUrl())))
                .collect(Collectors.toList());
    }

    @PostMapping
    User create(@RequestBody User user){
        userR.save(user);
        user.setImagenUrl(s3Service.getObjectUrl(user.getImagenUrl()));
        return user;
    }
}
