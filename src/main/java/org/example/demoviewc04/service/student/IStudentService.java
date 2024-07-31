package org.example.demoviewc04.service.student;

import org.example.demoviewc04.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student getById(int id);
    Student save(Student student);
    void delete(int id);
}
