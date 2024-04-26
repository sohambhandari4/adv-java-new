// Write a JSP page, which accepts user name in a text box and greets the user according 
//to the time on server machine.
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greeting Page</title>
</head>
<body>

<%
    // Get the current hour from the server
    int hour = java.time.LocalTime.now().getHour();
    
    // Determine the greeting based on the current hour
    String greeting = "";
    if (hour >= 5 && hour < 12) 
    {
        greeting = "Good morning";
    } else if (hour >= 12 && hour < 18) 
    {
        greeting = "Good afternoon";
    } 
    else
     {
        greeting = "Good evening";
    }
%>

<h2>Greeting Page</h2>

<%-- Display the greeting along with the username --%>
<%
    String username = request.getParameter("username");
    if (username != null && !username.isEmpty()) 
    {
%>
    <p><%= greeting %>, <%= username %>!</p>
<%
    } 
    else
     {
%>
    <p>Please enter your name:</p>
    <form method="post">
        <input type="text" name="username">
        <input type="submit" value="Submit">
    </form>
<%
    }
%>

</body>
</html>
