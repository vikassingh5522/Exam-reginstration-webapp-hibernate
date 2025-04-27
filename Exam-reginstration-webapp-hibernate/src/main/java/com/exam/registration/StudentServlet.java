package com.exam.registration;

import org.hibernate.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            updateStudent(request, response);
        } else {
            createStudent(request, response);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/students.jsp").forward(request, response);
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String examName = request.getParameter("examName");
        Student student = new Student(name, email, examName);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
        response.sendRedirect("students");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/student-form.jsp").forward(request, response);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String examName = request.getParameter("examName");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setName(name);
                student.setEmail(email);
                student.setExamName(examName);
                session.update(student);
                session.getTransaction().commit();
            }
        }
        response.sendRedirect("students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                session.getTransaction().commit();
            }
        }
        response.sendRedirect("students");
    }
}