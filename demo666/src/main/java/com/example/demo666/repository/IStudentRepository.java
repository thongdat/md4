package com.example.demo666.repository;

import com.example.demo666.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}