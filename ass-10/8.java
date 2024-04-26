<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>

<h2>Student Details</h2>

<form method="post">
    <label for="rno">Roll Number:</label>
    <input type="text" id="rno" name="rno"><br><br>
    
    <label for="sname">Student Name:</label>
    <input type="text" id="sname" name="sname"><br><br>
    
    <label for="gender">Gender:</label>
    <input type="radio" id="male" name="gender" value="Male">
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="Female">
    <label for="female">Female</label><br><br>
    
    <label for="comp_know">Computer Knowledge:</label>
    <select id="comp_know" name="comp_know">
        <option value="Beginner">Beginner</option>
        <option value="Intermediate">Intermediate</option>
        <option value="Advanced">Advanced</option>
    </select><br><br>
    
    <label for="class">Class:</label>
    <input type="text" id="class" name="class"><br><br>
    
    <input type="submit" value="Submit">
</form>

<%
    // Process form submission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String rno = request.getParameter("rno");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String comp_know = request.getParameter("comp_know");
        String classs = request.getParameter("class");
%>
        <h3>Details Entered:</h3>
        <p><strong>Roll Number:</strong> <%= rno %></p>
        <p><strong>Student Name:</strong> <%= sname %></p>
        <p><strong>Gender:</strong> <%= gender %></p>
        <p><strong>Computer Knowledge:</strong> <%= comp_know %></p>
        <p><strong>Class:</strong> <%= classs %></p>
<%
    }
%>

</body>
</html>
