<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 01-Feb-23
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<form action="/products?action=search" method="post">
    <input type="text" name="search">
    <button type="submit">Search</button>
</form>
    <a href="/products?action=create"><button>Create new product</button></a>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Company</td>
    </tr>
    <c:forEach var="product" items='${requestScope["products"]}'>
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getCompany()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">Exit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
