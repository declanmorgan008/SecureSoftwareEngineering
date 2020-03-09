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
            &nbsp;&nbsp;&nbsp;
            <a href="/logout">Logout</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/pay_fees">Pay Fees</a>
            &nbsp;&nbsp;&nbsp;
            <a href=${viewModulesLink}>View Modules</a>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>${message}'s Modules</h1>
        <h2>Message: ${message}</h2>
        <h2>${Error}</h2>

        <h2>Your Enrolled Modules:</h2>
        <table class="table table-striped" align="center" id="module-table">
            <thead class="thead">
                <tr>
                    <th scope="col">Module Code</th>
                    <th scope="col">Module Title</th>
                    <th scope="col">Grade</th>
                    <th scope="col">Options</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="module" items="${Enrolled}">
                    <tr>
                        <td><c:out value="${module.module.moduleCode}" /></td>
                        <td><c:out value="${module.module.name}" /></td>
                        <td><c:out value="${module.grade}" /></td>
                        <td>
                            <a href="<c:url value="/modules/${module.moduleCode}"/>">  View Module</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value="/unenroll/${module.moduleCode}/${username}/${password}"/>">  Un-Enroll</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>

</html>
