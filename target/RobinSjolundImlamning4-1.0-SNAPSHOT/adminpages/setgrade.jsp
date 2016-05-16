<%-- 
    Document   : setgrade
    Created on : 2016-maj-11, 14:18:36
    Author     : Robin_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sätt betyg</h1>

        <form method="POST" action="">
            <p><b>Kurs: </b>${course.namn}</p>
            <p><b>Student: </b>${student.namn}</p>
            <input type="hidden" name="student" value="${student.id}"><br>
            <input type="hidden" name="postType" value="setGrade">
            <input type="hidden" name="course" value="${course.id}"><br>
            <input type="radio" name="grade" value="IG" checked> IG<br>
            <input type="radio" name="grade" value="G"> G<br>
            <input type="radio" name="grade" value="VG"> VG<br>
            <input type="radio" name="grade" value="MVG"> MVG<br><br>
            <input type="submit" value="Spara">
        </form>

    </body>
</html>
