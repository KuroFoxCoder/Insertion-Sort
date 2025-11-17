import java.util.Scanner;
import java.util.ArrayList;

public class Sorter {
    public static void insertSort(int[] array)
    { //This method sorts the array.
        int count = 0;
        for(int i = 0; i < array.length; i++)
        {
            int j = i; //Set duplicate variable for use in sorting
            while(j > 0 && array[j] < array[j-1])
            {
                int temp = array[j]; //Clone variable so it doesn't get lost
                array[j] = array[j - 1]; //Move the higher value into the spot the old one was in
                array[j - 1] = temp; //Insert the replaced variable under the newly moved one
                count++;
                --j;
            }
        }
        System.out.print("SORTED: "); //Mark sorted array
        for(int i = 0; i<array.length;i++)
        {
            System.out.print(array[i] + " "); //Print every element of the array
        }
        System.out.println("Sort count: " + count);
    }

    public static void main(String[] args)
    {
        Scanner arrayMaker = new Scanner(System.in); //User input
        ArrayList<Integer> unsortedList = new ArrayList<Integer>(); //ArrayList for making an array
        String parseThis; //String for use in loop

        System.out.print("Input an integer, or press Enter to send the array to the sorter: "); //First prompt for the user to input a number
        parseThis = arrayMaker.nextLine(); //Make a String out of user input
        unsortedList.add(Integer.parseInt(parseThis)); //Add inputted integer into an ArrayList
        do //Do the loop until the next input is empty
        {
            System.out.print("Input an integer, or press Enter to send the array to the sorter: ");
            parseThis = arrayMaker.nextLine();
            if(!parseThis.isEmpty())
            {
                unsortedList.add(Integer.parseInt(parseThis));
            }
        }while(!arrayMaker.nextLine().isEmpty());
        System.out.print("Unsorted: ");
        for(int i = 0; i < unsortedList.size(); i++)
        {
            System.out.print(unsortedList.get(i) + " "); //Print unsorted array. It's technically an ArrayList right now, but this will fill the array to send to the sorting method.
        }
        int[] array = new int[unsortedList.size()]; //Make new array with matching size to the ArrayList
        for(int i = 0; i < array.length; i++)
        {
            array[i] = unsortedList.get(i); //Clone the ArrayList to the array of ints
        }
        insertSort(array); //Send the array to be sorted
    }
}
