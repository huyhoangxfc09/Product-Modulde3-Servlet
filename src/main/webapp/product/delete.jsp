<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02-Feb-23
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
  <a href="/products">Back to product list</a>
</p>
<form method="post">
  <h2>Are you sure?</h2>
  <fieldset style="width: 25%">
    <table>
      <tr>
        <td>Id: </td>
        <td>${requestScope["product"].getId()}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
      </tr>
      <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPrice()}</td>
      </tr>
      <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getDescription()}</td>
      </tr>
      <tr>
        <td>Company: </td>
        <td>${requestScope["product"].getCompany()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete product"></td>
        <td><button><a href="/products">Back</a></button></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
