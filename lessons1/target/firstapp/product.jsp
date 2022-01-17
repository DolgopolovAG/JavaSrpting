<%@ page import="gb.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    Product
</head>
<body>
    <h1>Product</h1>
    <hr>
        <ul>
        <%if (((List<Product>)request.getAttribute("product")) != null) %>
         <%for(Product p: (List<Product>)request.getAttribute("product")) {%>
            <li>id: <%=p.getId()%>; title: <%=p.getTitle()%>; cost: <%=p.getCost()%>. </li>
         <% } %>
        </ul>
    </hr>
</body>
</html>
