import java.io.*;
import java.util.*;


public class ReverseLines {
    
     /*

    First line has the number of lines that are in the file.
    Program should read each of those lines and then output the whole
    thing in reverse order (recommended to use array)


    */


    public static void main(String[] args){
        String fileName= "reverse.txt";
        FileReader file;
        BufferedReader buffer;
        String input;
        String[] arrayWords;

        int count;

        try {
            file = new FileReader(fileName);
            buffer = new BufferedReader(file);
            int numOfLines = Integer.parseInt(buffer.readLine());

            arrayWords = new String[numOfLines];
            while((input = buffer.readLine()) != null){

                //remove the 10
                input = input.replaceAll("10", "");

                //get each word
                for(String word: input.split(" ")){
                    
                    System.out.println(word);

                }


                

            }




        } catch (IOException error){
            System.out.println(error);
        }


    }


}

