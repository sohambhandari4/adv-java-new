import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class StudentTableDisplay extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public StudentTableDisplay() {
        setTitle("Student Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Add column headers to the table model
        model.addColumn("Roll Number");
        model.addColumn("Name");
        model.addColumn("Percentage");

        // Fetch data from the database and populate the table
        fetchDataFromDatabase();

        setVisible(true);
    }

    private void fetchDataFromDatabase() {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create SQL statement to select all records from the student table
            String sql = "SELECT * FROM student";

            // Execute the SQL query
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Populate the table model with data from the result set
            while (resultSet.next()) {
                String rollNumber = resultSet.getString("roll_number");
                String name = resultSet.getString("name");
                double percentage = resultSet.getDouble("percentage");

                // Add data to the table model
                model.addRow(new Object[]{rollNumber, name, percentage});
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Failed to fetch data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentTableDisplay::new);
    }
}
