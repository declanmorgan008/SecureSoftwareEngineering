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
        <br>
        <h2>Modules</h2>
        <br>

    </div>


    <table class="table table-striped" align="center">
        <thead class="thead">
        <tr>
            <th scope="col">Module Code</th>
            <th scope="col">Module Title</th>
            <th scope="col">Coordinator</th>
            <th scope="col">Available Slots</th>
            <th scope="col">Start Date</th>
            <th scope="col">End Date</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="module" items="${moduleList}">
                <tr>
                    <td><c:out value="${module.moduleCode}" /></td>
                    <td><c:out value="${module.name}" /></td>
                    <td><c:out value="${module.coordinator}" /></td>
                    <td><c:out value="${module.registeredStudents}"/>/<c:out value="${module.availableSlots}"/></td>
                    <td><c:out value="${module.startDate}" /></td>
                    <td><c:out value="${module.endDate}" /></td>
                    <td>
                            <a href="<c:url value="/enroll/${module.moduleCode}/${username}/${password}"/>">  Enroll</a>


                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>

</html>
