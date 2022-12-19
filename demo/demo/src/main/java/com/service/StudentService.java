package com.service;

import com.model.Student;
import com.repository.IStudentRepository;
import com.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return this.studentRepository.delete(id);
    }

    @Override
    public List<Student> sort() {
        return this.studentRepository.sort();
    }

    @Override
    public List<Student> reverse() {
        return this.studentRepository.reverse();
    }

    @Override
    public boolean add(Student student) {
        return this.studentRepository.add(student);
    }

    @Override
    public boolean edit(Student student) {
        return this.studentRepository.edit(student);
    }

    @Override
    public List<Student> search(String name) {
        return this.studentRepository.search( name);
    }
}
