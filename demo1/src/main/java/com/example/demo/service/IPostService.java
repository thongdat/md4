package com.example.demo.service;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);
    Post findById(Integer id);
    void save(Post post);
    void deleteById(Integer id);
}