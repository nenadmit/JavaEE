
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="commons/top.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="commons/nav-bar.jspf" %>




    <form action="/myWebApp/searchByDate" method="post">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="startDate">From:</label>
                <input type="date" class="form-control" name="startDate" id="startDate">
            </div><br/>
            <div class="form-group col-md-6">
                <label for="secondDate">To</label>
                <input type="date" class="form-control" name="secondDate" id="secondDate">
            </div><br/>
        </div>
        <input type="submit" class="btn btn-primary" value="submit"/>
    </form>

<p class="text-center">${warning}</p>


<c:forEach var="b" items="${arr.entrySet()}">
<h2 class="text-center">${b.getKey()}</h2>
<table class="table table-striped center" width="700">
    <thead>
    <tr>
        <th scope="col">Registraion Number</th>
        <th scope="col">Court</th>
        <th scope="col">Client</th>
        <th scope="col">Against</th>
        <th scope="col">Date</th>
        <th scope="col">Time</th>
        <th scope="col">Court Room</th>
        <th scope="col">Aditional Info</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${b.getValue()}">
        <tr>
            <td>${a.getRegNumber()}</td>
            <td>${a.getCourt()}</td>
            <td>${a.getClient()}</td>
            <td>${a.getAgainst()}</td>
            <td>${a.getDate()}</td>
            <td>${a.getTime()}</td>
            <td>${a.getCourtRoom()}</td>
            <td>${a.getAditionalInfo()}</td>

            <c:if test="${a.getId()>0}">
            <td><a href="/myWebApp/delete?id=${a.getId()}&firstDate=${firstDate}&secondDate=${secondDate}"><button class="btn btn-danger">Delete</button></a></td>

            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:forEach>




<%@include file="commons/scripts.jspf" %>
</body>
</html>
