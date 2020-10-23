
import java.io.*;

public class AddNumbers {
    
     /*

    Read the number on each line in numbers.txt and output the sum


    */

    public static void main(String[] args){

        String fileName = "numbers.txt";
        FileReader file;
        BufferedReader buffer;
        String input;
        

        try {      
            int sum = 0;

            file = new FileReader(fileName);
            buffer = new BufferedReader(file);

            while((input = buffer.readLine()) != null){

                //convert string to int
                int nextNum = Integer.parseInt(input);

                sum = sum + nextNum;

            }

            System.out.println("Sum is "+sum);
            
        } catch (IOException error){
            System.out.println(error);
        }



    }

    
}
