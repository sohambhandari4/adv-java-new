import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class CityCodeApplication extends JFrame {

    private Map<String, String> cityCodes;

    private JTextField cityNameField;
    private JTextField stdCodeField;
    private JTextArea outputArea;

    public CityCodeApplication() {
        setTitle("City Codes Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cityCodes = new HashMap<>();

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("City Name:"));
        cityNameField = new JTextField();
        inputPanel.add(cityNameField);
        inputPanel.add(new JLabel("STD Code:"));
        stdCodeField = new JTextField();
        inputPanel.add(stdCodeField);

        JButton addButton = new JButton("Add City");
        addButton.addActionListener(this::addCity);
        inputPanel.add(addButton);

        JButton removeButton = new JButton("Remove City");
        removeButton.addActionListener(this::removeCity);
        inputPanel.add(removeButton);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this::searchCity);
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addCity(ActionEvent e) {
        String cityName = cityNameField.getText().trim();
        String stdCode = stdCodeField.getText().trim();

        if (!cityName.isEmpty() && !stdCode.isEmpty()) {
            if (!cityCodes.containsKey(cityName)) {
                cityCodes.put(cityName, stdCode);
                outputArea.setText("City added: " + cityName + ", STD Code: " + stdCode);
            } else {
                outputArea.setText("City already exists.");
            }
        } else {
            outputArea.setText("Please enter both city name and STD code.");
        }
    }

    private void removeCity(ActionEvent e) {
        String cityName = cityNameField.getText().trim();

        if (!cityName.isEmpty()) {
            if (cityCodes.containsKey(cityName)) {
                cityCodes.remove(cityName);
                outputArea.setText("City removed: " + cityName);
            } else {
                outputArea.setText("City not found.");
            }
        } else {
            outputArea.setText("Please enter the city name to remove.");
        }
    }

    private void searchCity(ActionEvent e) {
        String cityName = cityNameField.getText().trim();

        if (!cityName.isEmpty()) {
            if (cityCodes.containsKey(cityName)) {
                String stdCode = cityCodes.get(cityName);
                outputArea.setText("City: " + cityName + ", STD Code: " + stdCode);
            } else {
                outputArea.setText("City not found.");
            }
        } else {
            outputArea.setText("Please enter the city name to search.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CityCodeApplication::new);
    }
}
