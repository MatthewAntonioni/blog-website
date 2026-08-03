package com.example.demo.publishing;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface postRepo extends JpaRepository<posts, Integer> {

    //add when i want to add the name checker to the database

    List<posts> findByPublished(int publish);

    
}
