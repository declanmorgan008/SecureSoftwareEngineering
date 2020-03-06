<%--<!DOCTYPE html>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html lang="en">--%>
<%--    <head>--%>

<%--        <!-- Access the bootstrap Css like this,--%>
<%--            Spring boot will handle the resource mapping automcatically -->--%>
<%--        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>



<%--    </head>--%>
<%--    <body>--%>

<%--        <nav class="navbar navbar-dark bg-dark">--%>
<%--            <div class="container">--%>
<%--                <div class="navbar-header">--%>
<%--                    <a class="navbar-brand" href="#">Springfield University</a>--%>
<%--                    <a href="/register">Register</a>--%>
<%--                    &nbsp;&nbsp;&nbsp;--%>
<%--                    <a href="/login">Login</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </nav>--%>

<%--        <div class="container">--%>

<%--            <div class="starter-template">--%>
<%--                <h1>Spring Boot Web JSP Example</h1>--%>
<%--                <h2>Message: ${message}</h2>--%>
<%--            </div>--%>

<%--        </div>--%>

<%--        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>

<%--    </body>--%>

<%--</html>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>