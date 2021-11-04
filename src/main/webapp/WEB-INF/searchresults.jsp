<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="padding: 20px;">

    <nav style="padding: 10px; display: flex; flex-direction: row; align-items: center;">
        <h2>Welcome <c:out value="${userInfo.getFirstname()}"></c:out> </h2>
        <a style="margin-left: 70%; margin-right: 2%;" class="btn btn-info" href="/">Home</a>
        <a class="btn btn-danger" href="/logout">Logout</a>
    </nav>
    <main>

        <div>
            <h4 style="margin-top: 50px; margin-bottom: 30px;">Find your pool!</h4>
            <form action="/search" method="POST">
                <div class="input-group mb-3" style="width: 30%;">
                    <input name="word" type="text" class="form-control" placeholder="New Search" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
                    </div>
                </div>
                <p style=" margin: 0; width: 500px;padding: 5px;  color: rgb(47, 47, 47); font-weight: 600;">
                    <c:out value="${Nofound}"></c:out>
                </p>
            </form>
        </div>

        <div>
            <table class="table table-hover" style="width: 70%;">
                <thead style="background-color: rgb(20, 20, 20); color: white; font-weight: 700;">
                    
                    <tr>
                        <td>Address</td>
                        <td>Pool Size</td>
                        <td>Cost per night</td>
                        <td>Details</td>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var = "pools" items = "${poolInfo}">
                    <tr>
                        <td><c:out value = "${pools.getAddress()}" ></c:out></td>
                        <td><c:out value = "${pools.getSize()}" ></c:out></td>
                        <td><c:out value = "${pools.getCost()}" ></c:out></td>
                        <td>
                            <a href="/details/${pools.getPool_id()}">Edit</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>