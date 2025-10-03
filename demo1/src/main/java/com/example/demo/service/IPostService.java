package com.example.demo.service;

import com.example.demo.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> findAll();
    Optional<Post> findById(int id);
    Post save(Post post);
    void deleteById(int id);
}
