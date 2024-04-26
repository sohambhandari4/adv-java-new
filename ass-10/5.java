<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>

<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Obtain DataSource from JNDI
        InitialContext context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDataSource");

        // Establish a connection
        conn = dataSource.getConnection();

        // Check if request is a postback
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Retrieve form data
            String ANo = request.getParameter("ANo");
            String Type = request.getParameter("Type");
            double Bal = Double.parseDouble(request.getParameter("Bal"));

            // Prepare SQL statement
            String sql = "INSERT INTO Account (ANo, Type, Bal) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ANo);
            pstmt.setString(2, Type);
            pstmt.setDouble(3, Bal);

            // Execute SQL statement
            pstmt.executeUpdate();
        }

        // Retrieve account details from database
        String query = "SELECT * FROM Account";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();
%>

<h2>Account Details</h2>
<table border="1">
    <tr>
        <th>Account Number</th>
        <th>Type</th>
        <th>Balance</th>
    </tr>
    <%
        while (rs.next()) {
            String ANo = rs.getString("ANo");
            String Type = rs.getString("Type");
            double Bal = rs.getDouble("Bal");
    %>
    <tr>
        <td><%=ANo%></td>
        <td><%=Type%></td>
        <td><%=Bal%></td>
    </tr>
    <%
        }
    %>
</table>

<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>

<form method="post">
    <label>Account Number:</label>
    <input type="text" name="ANo"><br><br>
    <label>Type:</label>
    <input type="text" name="Type"><br><br>
    <label>Balance:</label>
    <input type="text" name="Bal"><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
