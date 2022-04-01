package com.example.devdemo2.service;

import com.example.devdemo2.model.Blog;
import com.example.devdemo2.repository.BlogRepository;
import com.example.devdemo2.service.sqs.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final QueueService queueService;
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(QueueService queueService, BlogRepository blogRepository) {
        this.queueService = queueService;
        this.blogRepository = blogRepository;
    }
    public void save(final Blog blog) {
        blogRepository.save(blog);
    }

    public Blog findById(final String id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Iterable<Blog> findAll() { return blogRepository.findAll();}

    public List<Blog> findByPost(final String post){
        return blogRepository.findByPost(post);
    }
}
