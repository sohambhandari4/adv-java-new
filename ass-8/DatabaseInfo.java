// Write a program to display information about the database and list all the tables in the database. (Use DatabaseMetaData). 
import java.sql.*;
public class DatabaseInfo 
{
    public static void main(String[] args) 
    {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try
         {
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = conn.getMetaData();
            // Display information about the database
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            // List all tables in the database
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("\nTables in the Database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
