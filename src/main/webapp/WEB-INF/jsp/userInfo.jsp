<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="../../users.html">Back to users</a>
<p>
<c:if test="${!empty user}">
    <table class="tg">
        <tr>
            <td>Id:</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Login:</td>
            <td>${user.login}</td>
        </tr>
        <tr>
            <td>Photo:</td>
            <td> <img src="../../user/${user.id}/getPhoto" height="30%" width="30%"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>${user.password}</td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>${user.role}</td>
        </tr>
    </table>
</c:if>

</body>
</html>
