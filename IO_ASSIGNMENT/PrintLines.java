
import java.io.*;

public class PrintLines {

    /*

    Read each line in line.txt and output them


    */
 
    public static void main(String[] args){

        String fileName = "line.txt";
        FileReader file;
        BufferedReader buffer;
        String input;

        try {
            file = new FileReader(fileName);
            buffer = new BufferedReader(file);

            while((input = buffer.readLine()) != null){
                System.out.println(input);
            }

        } catch (IOException error){
            System.out.println(error);
        }
        
        

    }

}
