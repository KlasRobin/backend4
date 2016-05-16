/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.robinsjolundinlamning4.service;

import com.mycompany.robinsjolundinlamning4.businesslogic.Boundry;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robin_000
 */
@WebServlet(name = "KurserServle", urlPatterns = {"/", "/adminpages/KurserServlet"})
public class KurserServlet extends HttpServlet {

    @Inject
    Boundry boundry;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        String forward = "";
        System.out.print(path);
        switch (path) {

            case "/course":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("course", boundry.findCourseById(id));
                request.setAttribute("studentsInCourse", boundry.findStudentsByCourse(id));
                forward = "/course.jsp";
                break;
            case "/setgrade":
                int studid = Integer.parseInt(request.getParameter("studentid"));
                int courseid = Integer.parseInt(request.getParameter("courseid"));
                request.setAttribute("student", boundry.findStudentById(studid));
                request.setAttribute("course", boundry.findCourseById(courseid));
                forward = "/adminpages/setgrade.jsp";
                break;
            case "/adminpages/administrate":
                request.setAttribute("lazy", boundry.findLazyStudents());
                request.setAttribute("crapCourses", boundry.findStudentlessCourses());
                forward = "/adminpages/administrate.jsp";
                break;
            default:
                request.setAttribute("allCourses", boundry.findAllCourses());
                forward = "/index.jsp";
                break;
        }

        request.getRequestDispatcher(forward).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String redirect = null;
        String postType = request.getParameter("postType");

        switch (postType) {
            case "setGrade":
                int student = Integer.parseInt(request.getParameter("student"));
                int course = Integer.parseInt(request.getParameter("course"));
                redirect = "course?id=" + String.valueOf(course);
                String grade = request.getParameter("grade");
                boundry.gradeStudent(student, course, grade);
                break;
            case "deleteStudent":
                int studentToDelete = Integer.parseInt(request.getParameter("studentID"));
                boundry.deleteStudent(studentToDelete);
                redirect = "administrate";
                break;
            case "deleteCourse":
                int courseToDelete = Integer.parseInt(request.getParameter("courseID"));
                boundry.deleteCourse(courseToDelete);
                redirect = "administrate";
                break;
            case "addStudent":
                String studentToAdd = request.getParameter("name");
                boundry.addStudent(studentToAdd);
                redirect = "administrate";
                break;
            case "addCourse":
                String courseToadd = request.getParameter("name");
                boundry.addCourse(courseToadd);
                redirect = "administrate";
                break;

        }

        response.sendRedirect(redirect);

    }

}
