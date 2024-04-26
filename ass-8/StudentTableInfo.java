//. Write a program to display information about all columns in the student table. (Use ResultSetMetaData). 
import java.sql.*;
public class StudentTableInfo
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
            String sql = "SELECT * FROM student";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Column Information for Student Table:");
            for (int i = 1; i <= columnCount; i++)
             {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Data Type: " + metaData.getColumnTypeName(i));
                System.out.println("Is Nullable: " + metaData.isNullable(i));
                System.out.println("Is Auto Increment: " + metaData.isAutoIncrement(i));
                System.out.println();
            }
            // Close the database connection
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
