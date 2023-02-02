<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02-Feb-23
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Information</title>
</head>
<body>
<h1>Product information</h1>
<p><a href="/products">Back to product</a></p>
<form action="/products?action=edit" method="post">
<table style="border-collapse: collapse" border="1">
  <tr>
    <td>Id: </td>
    <td><input type="text" name="id" value="${requestScope["product"].getId()}"></td>
  </tr>
  <tr>
    <td>Name: </td>
    <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
  </tr>
  <tr>
    <td>Price: </td>
    <td><input type="text" name="price" value="${requestScope["product"].getPrice()}"></td>
  </tr>
  <tr>
    <td>Description: </td>
    <td><input type="text" name="description" value="${requestScope["product"].getDescription()}"></td>
  </tr>
  <tr>
    <td>Company: </td>
    <td><input type="text" name="company" value="${requestScope["product"].getCompany()}"></td>
  </tr>
  <tr>
    <td colspan="2" style="text-align: center"><input type="submit" value="Update"></td>
  </tr>
</table>
</form>
</body>
</html>
