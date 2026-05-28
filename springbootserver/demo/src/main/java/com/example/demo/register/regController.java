package com.example.demo.register;

import com.example.demo.Login.UserRepo;
import com.example.demo.register.registerRequest;
import com.example.demo.Login.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
//this never changes its just handling http requests and gets the file path

public class regController {
    
@Autowired
private UserRepo userRepository;

//autowired works as a manager of sorts it stops mutiple instances of the same object from getting out of control or interacting with each other

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody registerRequest request){

User user = userRepository.findByUsername(request.getUsername());

return ResponseEntity.status(400).body("Username already exists");

}
}
