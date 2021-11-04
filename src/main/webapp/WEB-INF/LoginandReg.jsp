<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <!-- <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <title>Login and Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div style="display: flex; flex-direction: row; justify-content: space-around;">
        <div class="bg-dark text-light mx-2 p-4 mt-3" style="border-radius: 10px; width: 300px;">
            <h1 class="text-info">Register</h1>
            
            

            <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                <c:out value="${rerrorMessage2}"></c:out>
            </p>

            <form action="/register" method="POST">
                <label style="display: block; padding-top: 10px;">First Name:</label>
                <input type="text" name="first_name" placeholder="Insert your First Name"/>
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${rerrorMessage3}"></c:out>
                </p>

                <label style="display: block; padding-top: 10px;">Last Name:</label>
                <input type="text" name="last_name" placeholder="Insert your Last Name"/>
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${rerrorMessage4}"></c:out>
                </p>

                <label style="display: block; padding-top: 10px;">Email:</label>
                <input type="text" name="email" placeholder="Insert your email"/>
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${rerrorMessage1}"></c:out>
                </p>

                <label style="display: block; padding-top: 10px;">Password:</label>
                <input type="password" name="password" placeholder="Insert your password"/>
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${rerrorMessage5}"></c:out>
                </p>

                <label style="display: block; padding-top: 10px;">Confirm Password:</label>
                <input type="password" name="passwordReview" placeholder="Insert your password"/>
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${rerrorMessage6}"></c:out>
                </p>

                <select name="admin" style="display: block; width: 150px; margin-top: 10px; font-weight: 700; font-size: 15px;">
                    <option>Host</option>
                    <option>Guest</option>
                </select>
                
                <button type="submit" class="btn btn-info mt-2" style="display: block;">Register</button>
            </form>
        </div>
        <div>
            <div class="bg-dark text-light mx-2 p-4 mt-3" style="border-radius: 10px; width: 300px;">
                <h1 class="text-success">Login</h1>
                
                <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                    <c:out value="${lerrorMessage1}"></c:out>
                </p>

                <form action="/login" method="POST">
    
                    <label style="display: block; padding-top: 10px;">Email:</label>
                    <input type="text" name="email" placeholder="Insert your email"/>
                    <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                        <c:out value="${lerrorMessage2}"></c:out>
                    </p>

                    <label style="display: block; padding-top: 10px;">Password:</label>
                    <input type="password" name="user_password" placeholder="Insert your password"/>
                    <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(163, 163, 163); font-weight: 600;">
                        <c:out value="${lerrorMessage3}"></c:out>
                    </p>

                    <button type="submit" class="btn btn-success mt-5" style="display: block;">Login</button>
                </form>
            </div>

        </div>
    </div>
</body>
</html>