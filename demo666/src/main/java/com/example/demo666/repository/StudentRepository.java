package com.example.demo666.repository;

import com.example.demo666.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }
}