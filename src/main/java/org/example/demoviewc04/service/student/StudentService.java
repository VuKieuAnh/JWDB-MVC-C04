package org.example.demoviewc04.service.student;

import org.example.demoviewc04.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Nguyen", 27));
        students.add(new Student(3, "Nguyen", 24));
        students.add(new Student(2, "Trang", 21));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student getById(int id) {
        return students.get(id);
    }

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public void delete(int id) {

    }
}
