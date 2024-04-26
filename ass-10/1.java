//Write a JSP script to accept username, store it into the session, compare it with 
//password in another jsp file, if username matches with password then display 
//appropriate message in html file.
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Username</title>
</head>
<body>

<h2>Enter Username</h2>

<form method="post" action="compare.jsp">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<%
    // Retrieve username from session
    String username = (String) session.getAttribute("username");

    // Hard-coded password map (in real scenario, you would retrieve this from a database)
    Map<String, String> passwordMap = new HashMap<>();
    passwordMap.put("user1", "password1");
    passwordMap.put("user2", "password2");
    passwordMap.put("user3", "password3");

    // Retrieve password for the given username
    String password = passwordMap.get(username);

    // Display appropriate message based on password match
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>Password Comparison</title>");
    out.println("</head>");
    out.println("<body>");
    if (password != null && password.equals(request.getParameter("password"))) 
    {
        out.println("<h2>Password Match!</h2>");
    } 
    else 
    {
        out.println("<h2>Password does not match!</h2>");
    }
    out.println("</body>");
    out.println("</html>");
%>
