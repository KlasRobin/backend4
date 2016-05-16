<%-- 
    Document   : index
    Created on : 2016-maj-11, 10:48:42
    Author     : Robin_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kurser</title>
    </head>
    <body>
        <h1>Kurser</h1>
        
        <ul>
            <c:forEach items="${allCourses}" var="course">
                <li><a href="/RobinSjolundImlamning4/course?id=${course.id}">${course.namn}</a></li>
            </c:forEach> 
        </ul>
        <hr>
        <a href="/adminpages/administrate">Administrera</a>
    </body>
</html>
