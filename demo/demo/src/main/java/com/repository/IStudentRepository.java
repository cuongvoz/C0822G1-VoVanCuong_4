package com.repository;

import com.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<Student> sort();
    List<Student> reverse();
    boolean delete(int id);
   boolean add(Student student);
   boolean edit(Student student);
    List<Student> search(String name);

}
