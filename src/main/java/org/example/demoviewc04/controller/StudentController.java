package org.example.demoviewc04.controller;

import org.example.demoviewc04.model.Student;
import org.example.demoviewc04.service.student.IStudentService;
import org.example.demoviewc04.service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentController", urlPatterns = "/students")
public class StudentController extends HttpServlet {
    private static IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//lay tham so action => neu action null
        String action = req.getParameter("action");
        action=action==null?"":action;
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            default:
                showAllStudent(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        ds khach hang
        List<Student> students = studentService.getAll();
//        System.out.println(students);
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/students.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action=action==null?"":action;
        switch (action) {
            case "create":
                createNewStudent(req, resp);
                break;
            default:
                showAllStudent(req, resp);
        }



    }

    private static void createNewStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Student student = new Student(id, name, age);
        IStudentService studentService = new StudentService();
        studentService.save(student);
        resp.sendRedirect("/students");
    }
}
