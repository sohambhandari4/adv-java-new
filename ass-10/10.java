<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Display</title>
</head>
<body>

<h2>User Display</h2>

<%
    // Initialize visit count
    Integer visitCount = (Integer) session.getAttribute("visitCount");
    if (visitCount == null) {
        visitCount = 1;
    } else {
        visitCount++;
    }
    session.setAttribute("visitCount", visitCount);
%>

<%
    // Process form submission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String userName = request.getParameter("userName");
        String nickName = request.getParameter("nickName");
        session.setAttribute("userName", userName);
        session.setAttribute("nickName", nickName);
    }
%>

<%
    // Display user details based on visit count
    String user = visitCount % 2 == 0 ? (String) session.getAttribute("nickName") : (String) session.getAttribute("userName");
%>
<p><strong>User:</strong> <%= user %></p>

<form method="post">
    <label for="userName">UserName:</label>
    <input type="text" id="userName" name="userName"><br><br>
    <label for="nickName">NickName:</label>
    <input type="text" id="nickName" name="nickName"><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
