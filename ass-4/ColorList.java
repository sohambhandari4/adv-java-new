//Construct a linked List containing names of colors: red, blue, yellow and orange. Then extend 
//your program to do the following:
//i. Display the contents of the List using an Iterator;
//ii. Display the contents of the List in reverse order using a ListIterator;
//iii. Create another list containing pink and green. Insert the elements of this list between blue and yellow.
import java.util.*;
public class ColorList 
{
    public static void main(String[] args) 
    {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("red", "blue", "yellow", "orange"));

        System.out.println("Contents of the list using an Iterator:");
        Iterator<String> iterator = colorList.iterator();
        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());
        }
        // ii. Display the contents of the list in reverse order using a ListIterator
        System.out.println("\nContents of the list in reverse order using a ListIterator:");
        ListIterator<String> listIterator = colorList.listIterator(colorList.size());
        while (listIterator.hasPrevious()) 
        {
            System.out.println(listIterator.previous());
        }

        // iii. Create another list containing pink and green
        LinkedList<String> additionalColors = new LinkedList<>(Arrays.asList("pink", "green"));
        ListIterator<String> insertionIterator = colorList.listIterator();
        while (insertionIterator.hasNext()) 
        {
            String color = insertionIterator.next();
            if (color.equals("blue"))
             {
                insertionIterator.add(additionalColors.getFirst());
                insertionIterator.add(additionalColors.getLast());
            }
        }

        // Display the modified color list
        System.out.println("\nModified color list:");
        System.out.println(colorList);
    }
}
