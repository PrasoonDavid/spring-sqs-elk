package com.example.devdemo2.controller;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.devdemo2.model.Blog;
import com.example.devdemo2.service.sqs.QueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final QueueService queueService;

    @Autowired
    public BlogController(QueueService queueService) {
        this.queueService = queueService;
    }


    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public SendMessageResult sendmessage(@RequestBody Blog blogObject) throws JsonProcessingException{
        return queueService.sendSqsMessage("queue-2",blogObject);
    }
}
