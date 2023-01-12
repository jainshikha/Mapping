package com.JPA.Mapping.service;

import com.JPA.Mapping.entity.ComponentEntity;
import com.JPA.Mapping.entity.TrackEntity;
import com.JPA.Mapping.repo.ComponentRepository;
import com.JPA.Mapping.repo.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    ComponentRepository componentRepository;
    @Autowired
    TrackRepository trackRepository;


    public ResponseEntity<List<ComponentEntity>> fetchAllPosts() {

        return ResponseEntity.ok(componentRepository.findAll());
    }



    public TrackEntity updatePost(TrackEntity updatedPost, Long id) {
      return  trackRepository.findById(id)
                .map(post -> {
                    post.setContent(updatedPost.getContent());
                    post.setDescription(updatedPost.getDescription());
                    post.setTitle(updatedPost.getTitle());
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new PostNotFoundException(id));
    }

}