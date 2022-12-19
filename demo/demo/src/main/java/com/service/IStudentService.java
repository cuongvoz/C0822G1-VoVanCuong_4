package com.service;

import com.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean delete(int id);
    List<Student> sort();
    List<Student> reverse();
    boolean add(Student student);
    boolean edit(Student student);
    List<Student> search(String name);
}
