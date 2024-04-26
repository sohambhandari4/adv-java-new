<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Email Validation</title>
</head>
<body>

<h2>Email Validation</h2>

<form method="post">
    <label for="email">Enter Email ID:</label>
    <input type="text" id="email" name="email">
    <input type="submit" value="Check">
</form>

<%
    // Process form submission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String email = request.getParameter("email");
        boolean isValid = isValidEmail(email);
%>
        <p><strong>Email ID:</strong> <%= email %></p>
        <p><strong>Validity:</strong> <%= isValid ? "Valid" : "Invalid" %></p>
<%
    }
%>

<%
    // Method to check if email is valid
    boolean isValidEmail(String email) {
        // Check if email contains one @ symbol
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        return count == 1;
    }
%>

</body>
</html>
