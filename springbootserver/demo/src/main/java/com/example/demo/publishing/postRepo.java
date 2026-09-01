package com.example.demo.publishing;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface postRepo extends JpaRepository<posts, Integer> {

    //unadded name checker as no real fault would occur if samne name exits

    List<posts> findByPublish(int publish);

    
}
