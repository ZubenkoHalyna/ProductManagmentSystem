<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<a href=${IndexPageAddress}>Back to main menu</a>
<p>
<form action = "/user/servlet-parameters" method = "POST">
    <table class="tg">
        <tr>
            <td>Login:</td>
            <td><input type = "text" name = "login" value="${login}"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type = "text" name = "password" value="${password}"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
