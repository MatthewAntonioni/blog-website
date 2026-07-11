package com.example.demo.publishing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepo extends JpaRepository<posts, Integer> {

    //add when i want to add the name checker to the database
    
}
