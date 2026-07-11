package com.example.demo.publishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.demo.publishing.*;


@RestController
@RequestMapping("/api/pub")

public class pubController {
    
    private postRepo postRepository;

@Autowired 
    public pubController(postRepo postRepository) {
        this.postRepository = postRepository;
    }

    //this is where the stuff we get fromt he database is used in various ways

   
@PostMapping("/post")
    public ResponseEntity<?>createPost(@RequestBody posts post){

        posts newPost = new posts();
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setPreview(post.getPreview());
        newPost.setPostID(post.getPostID());
        newPost.setPublish(post.isPublish());

        postRepository.save(newPost);

        return ResponseEntity.ok("post uploaed");
    }

}
