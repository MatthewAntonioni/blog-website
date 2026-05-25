package com.example.demo.Login;

import com.example.demo.Login.User;
import com.example.demo.Login.UserRepo;
import com.example.demo.Login.loginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    //this is where the stuff we get fromt he database is used in various ways
    
@Autowired
private UserRepo userRepository;

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody loginRequest request){

User user = userRepository.findByUsername(request.getUsername());

//add password hasing for security

if(user == null || !user.getPassword().equals(request.getPassword())){
    return ResponseEntity.status(401).body("Invalid username or password");

}

return ResponseEntity.ok("Login successful");

}
}
