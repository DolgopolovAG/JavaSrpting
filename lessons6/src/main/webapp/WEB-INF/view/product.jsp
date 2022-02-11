<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolgopolov
  Date: 31.01.2022
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Product id: ${product.id}</h2>
<h2>Product name: ${product.title}</h2>
<h2>Product price: ${product.cost}</h2>
<h2>Product manufacture_date: ${product.date}</h2>
<h2>Product manufacture_id: ${product.manuf_Id}</h2>

<c:url var = "deleteUrl" value="/product/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${deleteUrl}">Delete</a>

<br>

<c:url var = "editUrl" value="/product/edit">
    <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${editUrl}">Edit</a>

</body>
</html>

