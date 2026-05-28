package com.example.demo.Login;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {

    //this gives access to the data in the database

@Id
@Column(name = "userId")
private int userID;

@Column(name = "username")
private String username;

@Column(name = "password")
private String password;

@Column(name ="admin")
private boolean admin;

public int getUserID() {
    return userID;
}

public String getUsername() {
    return username;
}

public String getPassword() {
    return password;
}

public boolean isAdmin() {
    return admin;
}

public void setUsername(String username) {
    this.username = username;
}

public void setPassword(String password) {
    this.password = password;
}
}
