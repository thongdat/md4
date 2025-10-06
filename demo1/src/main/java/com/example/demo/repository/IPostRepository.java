package com.example.demo.repository;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface IPostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAll(Pageable pageable);
}