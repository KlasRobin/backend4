<%-- 
    Document   : administrate
    Created on : 2016-maj-11, 22:03:23
    Author     : Robin_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Kontrollpanel:</h1>
        <a href="/RobinSjolundImlamning4/index"><--- Tillbaka</a>
        <h2>Studenter utan kurser:</h2>
        <table border="1">
            <c:forEach items="${lazy}" var="stud">
                <tr>
                    <td>
                        ${stud.namn}   
                    </td>

                    <td>
                        <form method="post" action="">
                            <input type="hidden" name="postType" value="deleteStudent">
                            <input type="hidden" name="studentID" value="${stud.id}">
                            <input type="submit" value="Ta bort">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h2>Kurser utan studenter:</h2>
        <table border="1">
            <c:forEach items="${crapCourses}" var="course">
                <tr>
                    <td>
                    ${course.namn}   
                    </td>
                    <td>
                <form method="post" action="">
                    <input type="hidden" name="postType" value="deleteCourse">
                    <input type="hidden" name="courseID" value="${course.id}">
                    <input type="submit" value="Ta bort">
                </form>
                    </td>
            </tr>
        </c:forEach>
    </table>
        <h2>Lägg till student:</h2>
        <form method="POST" action="">
            <input type="hidden" name="postType" value="addStudent">
            Namn:<br>
            <input type="text" name="name">
            <input type="submit" value="Spara elev">
        </form>
        <hr>
        <h2>Lägg till kurs:</h2>
        <form method="POST" action="">
            <input type="hidden" name="postType" value="addCourse">
            Namn:<br>
            <input type="text" name="name">
            <input type="submit" value="Spara Kurs">
        </form>
</body>
</html>
