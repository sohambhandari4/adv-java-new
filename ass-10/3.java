//) Create a JSP page to accept a number from an user and display it in words:
//Example: 123 – One Two Three
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number to Words Converter</title>
</head>
<body>
    <h2>Number to Words Converter</h2>
    <form method="post" action="convert.jsp">
        <label>Enter a number:</label>
        <input type="number" name="number" min="0" required><br><br>
        <input type="submit" value="Convert">
    </form>
    
    <%-- Convert the number to words --%>
    <% String numberStr = request.getParameter("number");
       if (numberStr != null && !numberStr.isEmpty()) 
       {
           int number = Integer.parseInt(numberStr);
           String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
           String result = "";
           while (number > 0)
            {
               int digit = number % 10;
               result = words[digit] + " " + result;
               number = number / 10;
           }
    %>
    <h3>Conversion Result:</h3>
    <p><strong>Number:</strong> <%= request.getParameter("number") %></p>
    <p><strong>Number in Words:</strong> <%= result.trim() %></p>
    
    <% 
}
 %>
</body>
</html>
