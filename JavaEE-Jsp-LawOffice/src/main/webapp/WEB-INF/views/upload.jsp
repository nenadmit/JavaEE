
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="commons/top.jspf" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    form {
        width: 450px;
        height: 200px;
        margin: auto;
        position: relative;
    }
    input {
        width: 375px;
        height: auto;
    }
    input[type="file"] {
        background-color: rgba(204, 200, 200, 0.93);
        outline: none;
    }





</style>
<body>
<%@include file="commons/nav-bar.jspf" %>

<form action="upload" method="post" enctype="multipart/form-data">

    <input type="file" name="file" />
    <input class="btn btn-success" type="submit" value="Upload" />
    <p>${message}</p>
</form>

<form action="findFiles" method="post" >

    <input type="text" name="name" placeholder="Search" />
    <input class="btn btn-success" type="submit" value="Search" />
    <p>${messageTwo}</p>
</form>


<c:forEach var="b" items="${arr}">

    <table class="table table-striped center">
        <thead>
        <tr>
            <th scope="col">File Name</th>
            <th scope="col">File Type</th>
            <th scope="col">Last Modified</th>
            <th scope="col">Download</th>
        </tr>
        </thead>
        <tbody>

            <tr>
                <td>${b.getName()}</td>
                <td>${b.getExtension()}</td>
                <td>${b.getLastModified()}</td>
                <td><a href="findFiles?id=${b.getId()}"><button class="btn btn-success">Download</button></a></td>

            </tr>

        </tbody>
    </table>
</c:forEach>


<%@include file="commons/scripts.jspf" %>
</body>
</html>
