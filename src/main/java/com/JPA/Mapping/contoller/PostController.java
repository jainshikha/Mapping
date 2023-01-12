package com.example.jpa.manytomanydemo.controller;

import com.JPA.Mapping.entity.ComponentEntity;
import com.JPA.Mapping.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ComponentEntity>> getAllPosts(){
        return postService.fetchAllPosts();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePosts(@RequestBody Post updatedPost,@PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(updatedPost,id));
    }

}
