<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolgopolov
  Date: 31.01.2022
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<h1>Product list</h1>>
<ul>
    <c:forEach var="product" items="${products}">
        <c:url var = "viewUrl" value="/product/+ ${product.id}"/>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Product id: ${product.id}
            <br>
            Product name: ${product.name}
            <br>
            Product price: ${product.price}
            <br>
        </li>
    </c:forEach>
</ul>
<br>
<c:url var = "createUrl" value="/product/create"/>
<a href="${createUrl}">Create</a>
</body>
</html>
