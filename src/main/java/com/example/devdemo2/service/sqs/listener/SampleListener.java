package com.example.devdemo2.service.sqs.listener;

import com.example.devdemo2.model.Blog;
import com.example.devdemo2.service.BlogService;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class SampleListener {
    private final BlogService blogService;

    @Autowired
    SampleListener(BlogService blogService) {
        this.blogService = blogService;
    }
    @SqsListener(value = "queue-2", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void listenToSecondQueue(Blog blog)  {//will convert this to receive generic class or on some topic
        blogService.save(blog);
        log.info("Received a message on second queue: {}, blogservice: {}", blog,blogService);
    }
}