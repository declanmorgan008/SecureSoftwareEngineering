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
        <h1>Register as a Student</h1>
        <form method="post" th:action="@{/register}">
            <div class="form-group row">
                <label for="inputFirstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputFirstName" placeholder="Joe"
                           name="firstName" required/>
                    <div class="invalid-feedback">
                        Please enter your First Name.
                    </div>
                </div>
            </div>
            <div class="form-group row">
                    <label for="inputLastName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputLastName" placeholder="Bloggs"
                               name="lastName" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputTel" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-10">
                    <input type="tel" class="form-control" id="inputTel"
                           name="phoneNumber" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email"
                           name="email" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputAddress" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputAddress" placeholder="51 Sugar Street"
                           name="address" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username"
                           name="username" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password"
                           name="password" required/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </div>
        </form>
    </div>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>

</html>
