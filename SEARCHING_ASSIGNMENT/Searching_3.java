import java.util.*;
import java.io.*;


public class Searching_3 {
    

        public static void main(String args[]){

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter length of list:");
            int sizeList = sc.nextInt();

            int[] newArray = new int[sizeList];

            System.out.println("Initial Array Values: ");

            for(int i = 0; i < sizeList; i++){
                newArray[i] = (int)(Math.ceil(Math.random() * (Math.pow(sizeList, 2))));

                System.out.print(newArray[i] + " ");
            }

            try {

                System.out.println(" \n Enter a target to find: ");
                int targetNumber = sc.nextInt();

                if(targetNumber == 0){
                    //wants to exit
                    System.exit(0);
                } else {
                    //dont exit

                    newArray = searchArray(newArray, targetNumber, sizeList); // update array

                    System.out.print("\n Updated Array: ");

                    for(int i = 0; i < sizeList; i++){
                        System.out.print(newArray[i] + " ");
                    }

                }


            } catch (Exception error){
                System.out.print(error);
            }




        }


        public static int [] searchArray(int array[], int targetNumber, int sizeList){ 

            //declare vars
            boolean numFound = false;
    
            for (int i = 0; i < sizeList; i ++){
    
                if (array[i] == targetNumber || i != 0){
                array[i] = array[i - 1];
                array[i -1] = targetNumber;
                numFound = true;
                break;
                }
                else if (array[i] == targetNumber || i == 0){
                numFound = true;
                }
            }
            if (numFound == true){
                System.out.println(targetNumber + " was found");
                return array;
            }
            else{
                System.out.println(targetNumber + " was not found");
                return array;
            }
            }









}
