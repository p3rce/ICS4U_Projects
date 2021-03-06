import java.util.*;
import java.io.*;

public class Searching_5 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] newArray = new int[20]; //0-20

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (int)(Math.random() * 100);
        }

        // displayArrayValues(newArray);
      
          System.out.println("Enter number to search: ");
          int numberToSearch = sc.nextInt();

          int z = searchArray(newArray, numberToSearch);

          if(z == -1){
              //does not exist
              System.out.println(numberToSearch+" does not exist in the array");
              System.exit(0);
          } else {
              //found it!
              System.out.println("Number "+numberToSearch+" can be found at index "+z);
          }



    }


    public static void displayArrayValues(int[] newArray){
        for(int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }
    }

    public static int searchArray(int[] newArray, int target){
        int top = newArray.length - 1; //remove what the 0 makes
        int bottom = 0;
        int middle; //don't know yet
        boolean beenFound = false;
        int loc = -1;

        Arrays.sort(newArray);

        while(bottom <= top && beenFound == false){
            middle = bottom + ((top - bottom) / 2);

            if(newArray[middle] == target){
                beenFound = true;
                loc = middle;
            } else {

                if(newArray[middle] < target){
                    bottom = middle+1;
                } else {
                    top = middle -1;
                }

            }
        } //end of while loop

        return loc;


    }


    

}
