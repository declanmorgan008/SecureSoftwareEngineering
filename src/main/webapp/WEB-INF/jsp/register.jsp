<%--<!DOCTYPE html>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html lang="en">--%>
<%--<head>--%>

<%--    <!-- Access the bootstrap Css like this,--%>
<%--        Spring boot will handle the resource mapping automcatically -->--%>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>



<%--</head>--%>
<%--<body>--%>

<%--<nav class="navbar navbar-dark bg-dark">--%>
<%--    <div class="container">--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="#">Springfield University</a>--%>
<%--            <a href="/register">Register</a>--%>
<%--            &nbsp;&nbsp;&nbsp;--%>
<%--            <a href="/login">Login</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<%--<div class="container">--%>

<%--    <div class="starter-template">--%>
<%--        <h1>Register as a Student</h1>--%>
<%--        <form method="post" th:action="@{/register}">--%>
<%--            <div class="form-group row">--%>
<%--                <label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="text" class="form-control" id="inputFirstName" placeholder="Joe"--%>
<%--                           name="firstName" required/>--%>
<%--                    <div class="invalid-feedback">--%>
<%--                        Please enter your First Name.--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                    <label for="inputLastName" class="col-sm-2 col-form-label">Last Name</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <input type="text" class="form-control" id="inputLastName" placeholder="Bloggs"--%>
<%--                               name="lastName" required/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="inputTel" class="col-sm-2 col-form-label">Phone</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="tel" class="form-control" id="inputTel"--%>
<%--                           name="phoneNumber" required/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email"--%>
<%--                           name="email" required/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="form-group row">--%>
<%--                <div class="col-sm-10">--%>
<%--                    <button type="submit" class="btn btn-primary">Register</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>

<%--</div>--%>

<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>

<%--</body>--%>

<%--</html>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <%--@elvariable id="userForm" type=""--%>
    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>