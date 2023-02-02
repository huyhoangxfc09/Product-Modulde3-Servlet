<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 01-Feb-23
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Creat new product</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/products">Back to product list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Id</td>
        <<td><input type="number" name="id" id="id"></td>
      </tr>
      <tr>
        <td>Name</td>
        <<td><input type="Text" name="name" id="name"></td>
      </tr>
      <tr>
        <td>Price</td>
        <<td><input type="number" name="price" id="price"></td>
      </tr>
      <tr>
        <td>Description</td>
        <<td><input type="text" name="description" id="description"></td>
      </tr>
      <tr>
        <td>Company</td>
        <<td><input type="text" name="company" id="company"></td>
      </tr>
      <tr>
        <td colspan="2">
          <button type="submit">Create</button>
          <a href="/products">
            <button type="button">Back to home</button>
          </a>
        </td>
      </tr>
    </table>
  </fieldset>
</form>
<%--  <form action="/products">--%>
<%--    <input type="submit" value="Back">--%>
<%--  </form>--%>
</body>
</html>
