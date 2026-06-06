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
//field declartion for database access needs to be before constructor for unit testing to work because we need to access it before we start using it in the constutor 
    private UserRepo userRepository;

    //this contrusutor is so we can run unit tests and we need access to database stuff
@Autowired   
public AuthController(UserRepo userRepository) {
this.userRepository = userRepository;

    }

    //this is where the stuff we get fromt he database is used in various ways


@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody loginRequest request){

User user = userRepository.findByUsername(request.getUsername());

//add password hasing for security

if(user == null || !user.getPassword().equals(request.getPassword())){
    return ResponseEntity.status(401).body("Invalid username or password");

}

return ResponseEntity.ok("Login successful");

}

public boolean authenticate(String username, String password) {
    User user = userRepository.findByUsername(username);
    return user != null && user.getPassword().equals(password);

}

}