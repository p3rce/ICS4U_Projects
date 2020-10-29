/**
 * Searching_1
 */

import java.io.*;
import java.util.*;

public class Searching_1 {


    public static void main(String args[]){


    int[] randomArray = new int[20];

    Scanner sc = new Scanner(System.in);

    //generate 20 random numbers
    for(int i = 0; i<20; i++){
        int r = (int) Math.floor(Math.random() * 20);
        randomArray[i] = r;
    }


    System.out.println("Enter a number: ");
    int numberToSearch = sc.nextInt();

    int found = linearSearch(randomArray, numberToSearch);

    if (found == -1) {
        System.out.print("No results found");
    } else {
        System.out.print("Number found at index "+found);
    }

}



public static int linearSearch(int arr[], int elementToSearch) {

    for (int index = 0; index < arr.length; index++) {
        if (arr[index] == elementToSearch)
            return index;
    }
    return -1;
}







    //Helper method to view array values

    public static void printArrayValues(int array[]) {
        for(int element: array){
            System.out.println(element);
        }
    }


    
}
