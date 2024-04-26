<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Details</title>
</head>
<body>

<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Obtain DataSource from JNDI
        InitialContext context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDataSource");

        // Establish a connection
        conn = dataSource.getConnection();

        // Retrieve hospital details from database
        String query = "SELECT * FROM Hospital";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
%>

<h2>Hospital Details</h2>
<table border="1">
    <tr>
        <th>Hospital Number</th>
        <th>Name</th>
        <th>Address</th>
    </tr>
    <%
        while (rs.next()) {
            String HNo = rs.getString("HNo");
            String HName = rs.getString("HName");
            String Address = rs.getString("Address");
    %>
    <tr>
        <td><%=HNo%></td>
        <td><%=HName%></td>
        <td><%=Address%></td>
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
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>

</body>
</html>
