<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<html>
<head>
    <title>${user.login} info</title>
</head>
<body>
<a href=${UsersPageAddress}>Back to users</a>
<p>
<form action = "../../user/servlet-parameters" method = "POST" enctype="multipart/form-data">
<c:if test="${!empty user}">
    <table class="tg">
        <tr>
            <td>Id:</td>
            <td><input readonly="readonly" type = "text" name = "id" value="${user.id}"/></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type = "text" name = "login" value="${user.login}"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type = "text" name = "password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
            <select name = "role">
                <option value = "0">USER</option>
                <option value = "1">ADMIN</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Photo:</td>
            <td>
                    <input type="file" name="photo"  size="50"/>
                  <!--  <input type="submit" />-->
            </td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Submit"/></td>
        </tr>
    </table>
</c:if>
</form>
</body>
</html>
