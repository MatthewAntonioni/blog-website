package com.example.demo.drafts;

import com.example.demo.publishing.posts;
import com.example.demo.publishing.postRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//penis
@RestController
@RequestMapping("/api/posts")

public class draftlooker {
    
private postRepo pr;

@Autowired
public draftlooker(postRepo pr) {
    this.pr = pr;

}

@GetMapping("/drafts")
public ResponseEntity<List<posts>> getDrafts() {
    List<posts> drafts = pr.findByPublished(0); // Assuming 0 represents drafts
    return ResponseEntity.ok(drafts);
}

@GetMapping("/{id}")
public ResponseEntity<posts> getPost(@PathVariable int id){

posts post = pr.findById(id).orElse(null);

return ResponseEntity.ok(post);



}
    
}
