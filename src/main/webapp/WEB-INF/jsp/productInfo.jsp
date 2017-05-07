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
            text-align: right;
        }

        .tg.tg-4eph {
            background-color: #f9f9f9;
        }

    </style>
</head>
<body>
<a href="../../products.html">Back to products</a>
<p>

<c:if test="${!empty product}">
<table class="tg">
    <tr>
        <td>Id:</td>
        <td>${product.id}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Producer</td>
        <td>${product.producer}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${product.description}</td>
    </tr>
</table>
</c:if>

</body>
</html>
