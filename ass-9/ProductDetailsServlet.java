import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL query to retrieve product details
        String query = "SELECT ProdCode, PName, Price FROM Product";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Execute SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Display product details in tabular format
            out.println("<html>");
            out.println("<head><title>Product Details</title></head>");
            out.println("<body>");
            out.println("<h2>Product Details</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Product Code</th><th>Product Name</th><th>Price</th></tr>");
            while (resultSet.next()) {
                String prodCode = resultSet.getString("ProdCode");
                String pName = resultSet.getString("PName");
                double price = resultSet.getDouble("Price");
                out.println("<tr><td>" + prodCode + "</td><td>" + pName + "</td><td>" + price + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            out.println("SQL Exception: " + e.getMessage());
        }
    }
}
