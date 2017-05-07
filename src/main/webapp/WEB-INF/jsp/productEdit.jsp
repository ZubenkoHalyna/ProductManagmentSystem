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
<a href=${ProductsPageAddress}>Back to products</a>
<p>
<form action = "../../product/servlet-parameters" method = "POST">
    <c:if test="${!empty product}">
        <table class="tg">
            <tr>
                <td>Id:</td>
                <td><input readonly="readonly" type = "text" name = "id" value="${product.id}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type = "text" name = "name" value="${product.name}"/></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type = "text" name = "producer" value="${product.producer}"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type = "text" name = "price" value="${product.price}"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type = "text" name = "description" value="${product.description}"/></td>
            </tr>
            <tr>
                <td colspan = "2"><input type = "submit" value = "Submit"/></td>
            </tr>
        </table>
    </c:if>
</form>
</body>
</html>
