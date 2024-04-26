// Create a Hash table containing Employee name and Salary. Display the details of the hash 
//table. Also search for a specific Employee and display Salary of that Employee.
import java.util.Hashtable;
import java.util.Scanner;

public class EmployeeHashTable 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String, Double> employeeSalaries = new Hashtable<>();

        // Adding some employees and their salaries for demonstration
        employeeSalaries.put("John", 50000.0);
        employeeSalaries.put("Alice", 60000.0);
        employeeSalaries.put("Bob", 55000.0);
        employeeSalaries.put("Emily", 62000.0);

        // Display details of the hashtable
        System.out.println("Details of the Hash Table:");
        for (String name : employeeSalaries.keySet()) 
        {
            System.out.println("Employee: " + name + ", Salary: " + employeeSalaries.get(name));
        }

        // Search for a specific employee
        System.out.print("\nEnter the name of the employee to search for: ");
        String searchName = scanner.nextLine();

        if (employeeSalaries.containsKey(searchName)) 
        {
            System.out.println("Salary of " + searchName + " is " + employeeSalaries.get(searchName));
        }
         else
          {
            System.out.println("Employee " + searchName + " not found in the hashtable.");
        }
        scanner.close();
    }
}
