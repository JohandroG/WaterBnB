<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <nav style="padding: 10px; display: flex; flex-direction: row; align-items: center;">
        <h2>Welcome <c:out value="${userInfo.getFirstname()}"></c:out> </h2>
        <a class="btn btn-danger" style="margin-left: 70%;" href="/logout">Logout</a>
    </nav>

    <main>
<div style="margin: 10px; width: 70%;">
            <h4>Current Listings</h4>
    
            <table class="table table-hover" style="width: 90%;">
                <thead style="background-color: rgb(20, 20, 20); color: white; font-weight: 700;">
                    <tr>
                        <td>Address</td>
                        <td>Pool Size</td>
                        <td>Cost per night</td>
                        <td>Edit</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "pools" items = "${userInfo.getPools()}">
                    <tr>
                        <td><c:out value = "${pools.getAddress()}" ></c:out></td>
                        <td><c:out value = "${pools.getSize()}" ></c:out></td>
                        <td><c:out value = "${pools.getCost()}" ></c:out></td>
                        <td>
                            <a href="/edit/${pools.getPool_id()}">Edit</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
</div>


<div style="margin: 10px; width: 60%; padding: 30px; border-radius: 20px; background-color: rgb(226, 226, 226);">
    <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(47, 47, 47); font-weight: 600;">
        <c:out value="${derrorMessage2}"></c:out>
    </p>
    <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(47, 47, 47); font-weight: 600;">
        <c:out value="${derrorMessage1}"></c:out>
    </p>
    <p style=" margin: 0; width: 200px;padding: 5px;  color: rgb(47, 47, 47); font-weight: 600;">
        <c:out value="${dsuccess}"></c:out>
    </p>
            <form method="POST" action="/newpool">
                <div class="form-row">

                </div>
                <div class="form-group">
                <label for="inputAddress">Address</label>
                <input name="address" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                </div>
                <div class="form-group">
                <label for="inputAddress2">Description</label>
                <textarea name="desc" type="text" class="form-control" id="inputAddress2" placeholder="Description"></textarea>
                </div>
                <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="inputCity">Cost per night</label>
                    <input name="cost" placeholder="0.00" type="number" class="form-control" id="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">Size</label>
                    <select id="inputState" class="form-control" name="size">
                    <option>Small</option>
                    <option>Medium</option>
                    <option>Large</option>
                    </select>
                </div>
                </div>
                <div class="form-group">
                </div>
                <input name="creator_id" type="hidden" value="${userInfo.getUser_id()}">
                <button type="submit" class="btn btn-primary">Add Listing</button>
            </form>
</div>


    </main>
</body>
</html>