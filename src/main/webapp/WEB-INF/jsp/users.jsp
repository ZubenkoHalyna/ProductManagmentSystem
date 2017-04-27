<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %>
<html>
<head>
    <title>Products Page</title>
    <style type="=text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg.tg-4eph {
            background-color: #f9f9f9;
        }

    </style>
</head>
<body>
<a href="../index.html">Back to main menu</a>
<p>
<h2>Products:</h2>
<p>
<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Login</th>
            <th width="60">Password</th>
            <th width="60">Role</th>
            <th width="120">Edit</th>
            <th width="120">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/info/${user.id}"> ${user.name}</a></td>
                <td>${user.price}</td>
                <td>${user.producer}</td>
                <td>${user.description}</td>
                <td> <a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
                <td> <a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<form action = "/edit/servlet-parameters" method = "get">
    <input type = "submit" value = "Add"/>
</form>
</body>
</html>
