package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.implementationServices.UserImplemServ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserImplemServ userImplemServ;
 @CrossOrigin(origins = "http://localhost:9090")
 @PostMapping("/users/register")
    public User register(@RequestBody User user) {
        return userImplemServ.registerUser(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<IdToken> authenticate(@RequestBody User user) {
        String token = userImplemServ.loginAndGetToken(user.email, user.password);
        return new ResponseEntity<>(new IdToken(token), HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userImplemServ.findAllUsers();
    }
}

class IdToken {
    private String id_token;

    IdToken(String idToken) {
        id_token = idToken;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
