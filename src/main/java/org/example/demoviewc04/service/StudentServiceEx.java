package org.example.demoviewc04.service;

import org.example.demoviewc04.model.Student;

import java.util.Collections;
import java.util.List;

public class StudentServiceEx implements IStudentService {
    @Override
    public List<Student> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
