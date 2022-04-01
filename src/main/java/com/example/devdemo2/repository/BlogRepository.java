package com.example.devdemo2.repository;

import com.example.devdemo2.model.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
    List<Blog> findByPost(String post);

}
