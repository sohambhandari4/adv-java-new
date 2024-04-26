//Write a menu driven program (Command line interface) to perform the following operations on 
//student table. 1. Insert 2. Modify 3. Delete 4. Search 5. View All 6. Exit
import java.sql.*;
import java.util.Scanner;
public class StudentManagementSystem
 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Modify");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. View All");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
           
            int choice = scanner.nextInt();
            switch (choice)
             {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    modifyStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    viewAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void insertStudent() 
    {
        System.out.println("Inserting student...");
    }

    private static void modifyStudent() 
    {
        System.out.println("Modifying student...");
    }

    private static void deleteStudent()
     {
        System.out.println("Deleting student...");
    }

    private static void searchStudent() 
    {
        System.out.println("Searching for student...");
    }

    private static void viewAllStudents() 
    {
        System.out.println("Viewing all students...");
    }
}
