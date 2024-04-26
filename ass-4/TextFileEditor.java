import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileEditor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java TextFileEditor <filename>");
            return;
        }

        String filename = args[0];
        List<String> lines = readFromFile(filename);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert line");
            System.out.println("2. Delete line");
            System.out.println("3. Append line");
            System.out.println("4. Modify line");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertLine(lines, scanner);
                    break;
                case 2:
                    deleteLine(lines, scanner);
                    break;
                case 3:
                    appendLine(lines, scanner);
                    break;
                case 4:
                    modifyLine(lines, scanner);
                    break;
                case 5:
                    saveToFile(filename, lines);
                    System.out.println("File saved. Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    private static List<String> readFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return lines;
    }

    private static void insertLine(List<String> lines, Scanner scanner) {
        System.out.print("Enter line number to insert: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (lineNumber >= 1 && lineNumber <= lines.size() + 1) {
            System.out.print("Enter line to insert: ");
            String line = scanner.nextLine();
            lines.add(lineNumber - 1, line);
            System.out.println("Line inserted successfully.");
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private static void deleteLine(List<String> lines, Scanner scanner) {
        System.out.print("Enter line number to delete: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (lineNumber >= 1 && lineNumber <= lines.size()) {
            lines.remove(lineNumber - 1);
            System.out.println("Line deleted successfully.");
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private static void appendLine(List<String> lines, Scanner scanner) {
        System.out.print("Enter line to append: ");
        String line = scanner.nextLine();
        lines.add(line);
        System.out.println("Line appended successfully.");
    }

    private static void modifyLine(List<String> lines, Scanner scanner) {
        System.out.print("Enter line number to modify: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (lineNumber >= 1 && lineNumber <= lines.size()) {
            System.out.print("Enter new line: ");
            String newLine = scanner.nextLine();
            lines.set(lineNumber - 1, newLine);
            System.out.println("Line modified successfully.");
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private static void saveToFile(String filename, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
