<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02-Feb-23
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
    <h1>Edit product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <form method="post">
        <fieldset style="width: 25%">
            <legend>Product information</legend>
            <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>
            </tr>
            <tr>
                <td>Company</td>
                <td><input type="text" name="company" id="company" value="${requestScope["product"].getCompany()}"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Update</button>
                    <a href="/products">
                        <button type="button">Back to home</button>
                    </a>
                </td>
            </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
