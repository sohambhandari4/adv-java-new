<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Mall - Page 1</title>
</head>
<body>
    <h2>Shopping Mall - Page 1</h2>
    <form action="page2.jsp" method="post">
        <label>Product 1 Price:</label>
        <input type="number" name="product1_price" min="0"><br><br>
        <label>Product 2 Price:</label>
        <input type="number" name="product2_price" min="0"><br><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Mall - Page 2</title>
</head>
<body>
    <h2>Shopping Mall - Page 2</h2>
    <form action="bill.jsp" method="post">
        <label>Product 3 Price:</label>
        <input type="number" name="product3_price" min="0"><br><br>
        <label>Product 4 Price:</label>
        <input type="number" name="product4_price" min="0"><br><br>
        <input type="hidden" name="product1_price" value="<%= request.getParameter("product1_price") %>">
        <input type="hidden" name="product2_price" value="<%= request.getParameter("product2_price") %>">
        <input type="submit" value="Next">
    </form>
</body>
</html>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Mall - Bill</title>
</head>
<body>
    <h2>Shopping Mall - Bill</h2>
    <%-- Retrieve product prices from previous pages --%>
    <% int product1Price = Integer.parseInt(request.getParameter("product1_price"));
       int product2Price = Integer.parseInt(request.getParameter("product2_price"));
       int product3Price = Integer.parseInt(request.getParameter("product3_price"));
       int product4Price = Integer.parseInt(request.getParameter("product4_price"));
       
       // Calculate total
       int total = product1Price + product2Price + product3Price + product4Price;
    %>
    <h3>Bill Details:</h3>
    <p>Product 1 Price: <%= product1Price %></p>
    <p>Product 2 Price: <%= product2Price %></p>
    <p>Product 3 Price: <%= product3Price %></p>
    <p>Product 4 Price: <%= product4Price %></p>
    <p>Total: <%= total %></p>
</body>
</html>
