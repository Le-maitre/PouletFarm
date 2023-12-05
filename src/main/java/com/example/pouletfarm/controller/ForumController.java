package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Forum;

import com.example.pouletfarm.service.ForumService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/forums")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }
  
    @PostMapping("/create")
    public ResponseEntity<Forum> createForum( @RequestParam("forum") String forumString,
    @RequestParam(value ="imageUrl", required=false) MultipartFile multipartFile) throws Exception {

        Forum forum = new Forum(); 
         try{
        forum = new JsonMapper().readValue(forumString, Forum.class);
    }catch(JsonProcessingException e){
        throw new Exception(e.getMessage());
    }
    Forum savedUser = forumService.createForum(forum,multipartFile, java.util.Optional.empty());

    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);                                  
      
    }

    @GetMapping("/{id}")
    public ResponseEntity<Forum> getForumById(@PathVariable Long id) {
        Forum forum = forumService.getForumById(id);
        if (forum != null) {
            return new ResponseEntity<>(forum, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Forum>> getAllForums() {
        List<Forum> forums = forumService.getAllForums();
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Forum> updateForum(@RequestBody Forum forum) {
        Forum updatedForum = forumService.updateForum(forum);
        return new ResponseEntity<>(updatedForum, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteForum(@PathVariable Long id) {
        forumService.deleteForum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
