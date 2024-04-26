//Write a JSP program to check whether given number is Armstrong or not. (Use Include directive).
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Armstrong Number Checker</title>
</head>
<body>
    <h2>Armstrong Number Checker</h2>
    
    <%@ include file="ArmstrongLogic.jsp" %>
    
    <form method="post" action="">
        <label>Enter a number:</label>
        <input type="number" name="number" min="0" required><br><br>
        <input type="submit" value="Check">
    </form>
    
    <%-- Display the result --%>
    <% if (request.getAttribute("isArmstrong") != null) 
    { 
        %>
        <% boolean isArmstrong = (boolean) request.getAttribute("isArmstrong"); %>
        <p><strong><%= request.getParameter("number") %></strong> is <%= isArmstrong ? "an Armstrong" : "not an Armstrong" %> number.</p>
    <%
 }
     %>
</body>
</html>
