
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="commons/top.jspf" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form action = "login" method="post">

    <input type="text" name="username" placeholder="Username"/><br>
    <input type="password" name="password" placeholder="Password"/><br>
    <input type="submit" value="Log In" class="btn btn-primary"/>



</form>
${message}






</body>
</html>
