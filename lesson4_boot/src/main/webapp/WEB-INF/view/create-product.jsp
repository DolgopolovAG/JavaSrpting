<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolgopolov
  Date: 31.01.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<%--@elvariable id="product" type="lesson3.entity.Product"--%>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value ="${product.id}"/>
    Name: <form:input path="name"/>
    <br>
    Price: <form:input path="price"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
