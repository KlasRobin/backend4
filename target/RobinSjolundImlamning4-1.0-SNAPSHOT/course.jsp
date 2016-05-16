<%-- 
    Document   : course
    Created on : 2016-maj-11, 11:18:30
    Author     : Robin_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${course.namn}</title>
    </head>
    <body>
        <h1>${course.namn}</h1>
        <h2>Elever:</h2>
        <a href="/RobinSjolundImlamning4/index"><--- Tillbaka</a><br><br><br>
        <table style="width:25%" border="1">
            <thead>
            <tr>
                <th>Student</th>
                <th>Betyg</th>		
           </tr>
           </thead>
           <tbody>
        <c:forEach items="${studentsInCourse}" var="courseId">
            <tr>
                <td>
                 <a href="/RobinSjolundImlamning4/setgrade?studentid=${courseId.studenter.id}&courseid=${courseId.kurser.id}">${courseId.studenter.namn}</a>    
                </td>
                <c:choose>
                <c:when test="${courseId.betyg==null}">
                <td>Ej betygsatt</td>
                </c:when>
                <c:otherwise>  
                <td>${courseId.betyg}</td>
                </c:otherwise>
                </c:choose>
            </tr>    
        
            
        </c:forEach>
          </tbody>  
        </table>
</table>
</body>
</html>
