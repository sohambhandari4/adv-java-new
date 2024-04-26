//. Accept ‗n‘ integers from the user and store them in a collection. Display them in the sorted 
//order. The collection should not accept duplicate elements. (Use a suitable collection). Search for an 
//particular element using predefined search method in the Collection framework.
import java.util.*;
public class Main 
{
    public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> integerSet = new TreeSet<>();

        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
         {
            int num = scanner.nextInt();
            integerSet.add(num);
        }

        // Display integers in sorted order
        System.out.println("Integers in sorted order:");
        for (int num : integerSet)
         {
            System.out.print(num + " ");
        }
        System.out.println();

        // Search for a particular element
        System.out.print("Enter the element to search for: ");
        int searchElement = scanner.nextInt();

        if (integerSet.contains(searchElement)) 
        {
            System.out.println(searchElement + " found in the collection.");
        }
         else
          {
            System.out.println(searchElement + " not found in the collection.");
        }
        scanner.close();
    }
}
