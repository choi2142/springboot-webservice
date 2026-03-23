package com.example.controller;

import com.example.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class WebRestController {

    @Autowired
    private PostsService postsService;

    // Other endpoints...

    @PostMapping("/{id}/restore")
    public ResponseEntity<String> restorePost(@PathVariable Long id) {
        postsService.restorePost(id);
        System.out.println("Post with ID " + id + " has been restored successfully.");
        return ResponseEntity.ok("Post restored successfully.");
    }
}