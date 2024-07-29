package org.example.demoviewc04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="customerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        // Hello
//        ma logic lan voi html -> code ban
//        khong the su dung dc css
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Day la trang khach hang</h1>");
        out.println("<h1>"+name+"</h1>");
        out.println("<h1>"+age+"</h1>");
        out.println("</body></html>");
    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String pass = req.getParameter("pw");
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1> Day la trang dang nhap</h1>");
//        out.println("<h1>"+name+"</h1>");
//        out.println("<h1>"+pass+"</h1>");
//        out.println("</body></html>");
//    }
}
