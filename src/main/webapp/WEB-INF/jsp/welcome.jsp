<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>

        <!-- Access the bootstrap Css like this,
            Spring boot will handle the resource mapping automcatically -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">



    </head>
    <body>

        <nav class="navbar navbar-dark bg-dark">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Springfield University</a>
                    <a href="/register">Register</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/login">Login</a>
                </div>
            </div>
        </nav>

        <div class="container">

            <div class="starter-template">
                <h1>Spring Boot Web JSP Example</h1>
                <h2>Message: ${message}</h2>
            </div>

            <c:forEach var="student" items="${listStudents}">
                <tr>
                    <td><c:out value="${student.firstName}" /></td>
                    <td><c:out value="${student.lastName}" /></td>
                    <td>
                        <a href="/books/${student.studentId}"/>Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete/${student.studentId}"  />Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>

</html>
