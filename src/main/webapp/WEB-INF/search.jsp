<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

    <nav style="padding: 10px;">
        <a class="btn btn-success" style="margin-left: 80%;" href="user">Sing in/ Sign up</a>
    </nav>

    <main style="display: flex; flex-direction: column; align-items: center; margin-top: 50px;">
        <h2>Find places to swim and sleep on water bnb!</h2>
        <form action="/search" method="POST">
            <div class="input-group mb-3">
                <input name="word" type="text" class="form-control" placeholder="Search here" aria-label="Recipient's username" aria-describedby="button-addon2">
                <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>