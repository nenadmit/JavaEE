
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="commons/top.jspf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="commons/nav-bar.jspf" %>


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
    <c:forEach var="a" items="${arr}">
        <tr>
            <td>${a.getRegNumber()}</td>
            <td>${a.getCourt()}</td>
            <td>${a.getClient()}</td>
            <td>${a.getAgainst()}</td>
            <td>${a.getDate()}</td>
            <td>${a.getTime()}</td>
            <td>${a.getCourtRoom()}</td>
            <td>${a.getAditionalInfo()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>




</body>
</html>
