package com.example.devdemo2.controller;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.devdemo2.model.Blog;
import com.example.devdemo2.service.BlogService;
import com.example.devdemo2.service.sqs.QueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final QueueService queueService;
    private final BlogService blogService;
    @Autowired
    public BlogController(QueueService queueService, BlogService blogService) {
        this.queueService = queueService;
        this.blogService = blogService;
    }


    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public SendMessageResult sendmessage(@RequestBody Blog blogObject) throws JsonProcessingException{
        return queueService.sendSqsMessage("queue-2",blogObject);
    }
    @GetMapping(value= "/elk/{id}")
    public Blog findById(@PathVariable final String id){
        return blogService.findById(id);
    }

    @GetMapping(value= "/elk/")
    public Iterable<Blog> findAll(){
        return blogService.findAll();
    }

    @GetMapping(value="/elk/find/{post}")
    public List<Blog> findByPost(@PathVariable final String post){
        return blogService.findByPost(post);
    }
}
