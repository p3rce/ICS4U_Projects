import java.io.*;

public class PrintAllChars {
    
    /*

    Read all the lines in allChar.txt and print each character on each line on a new line, excluding the spaces, \n and \r


    */

    public static void main(String[] args){


        String fileName = "allChar.txt";
        FileReader file;
        BufferedReader buffer;
        String input;

        try {
            file = new FileReader(fileName);
            buffer = new BufferedReader(file);

            while((input = buffer.readLine()) != null){

                //remove all instances of spaces
                input = input.replaceAll("\\s+", "");

                //remove \n and \r
                input = input.replace("\n", "");
                input = input.replace("\r", "");


                for(String word : input.split("")){
                    
                    System.out.println(word);

                }

            }

        } catch (IOException error){
            System.out.println(error);
        }


    }

}
